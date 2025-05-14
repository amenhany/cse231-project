package org.hotelbooking.core;

import org.hotelbooking.accommodation.Accommodation;
import org.hotelbooking.accommodation.Room;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private final List<Accommodation> accommodations;
    private final List<Booking> bookings;


    public HotelManager() {
        accommodations = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addAccommodation (@NotNull Accommodation accommodation) throws IllegalArgumentException {
        if(accommodation.getPricePerNight() <= 0 ){
            throw new IllegalArgumentException("Price can't be negative");
        }
        if(accommodation.getCapacity() <= 0 ){
            throw new IllegalArgumentException("Capacity can't be negative");
        }
        for(Accommodation entry : accommodations) {
            if(entry.getAccommodationId().equals(accommodation.getAccommodationId())){
                throw new IllegalArgumentException("Accommodation with the same ID already exists");
            }
        }
        accommodations.add(accommodation);
        accommodations.sort(null);
    }

    public @Nullable Accommodation checkin(@NotNull Booking booking) {

        List<Accommodation> availableAccommodations = new ArrayList<>();
        Accommodation suitableAccommodation = null;
        int minCapacity = 9999;

        if (booking.getEndDate().isBefore(booking.getStartDate())){
            booking.setStatus(BookingStatus.REJECTED);
            throw new IllegalArgumentException("End date cannot be before Start Date");

        }

        if(booking.getStatus() != BookingStatus.CONFIRMED_PAYMENT){
            throw new IllegalArgumentException("Payment is not confirmed or Booking is cancelled");
        }

        for (Accommodation accommodation:accommodations) {
           if ( accommodation.matches(booking.getDesiredAccommodation() )
                   && ( booking.getGuests().length <= accommodation.getCapacity() ) ){

               boolean isAvailable = true;
               for (Booking booked: bookings ) {
                   if (booked.getAccommodation()==accommodation) {
                        if (!(booking.getStartDate().isAfter(booked.getEndDate()) || booking.getEndDate().isBefore(booked.getStartDate()))) {
                            isAvailable=false;
                            break;
                       }
                   }
               }
               if (isAvailable) {
                   availableAccommodations.add(accommodation);
               }
           }
        }

        for (Accommodation accommodation : availableAccommodations) {
            int capacityDifference = accommodation.getCapacity() - booking.getGuests().length;
            if (capacityDifference < minCapacity) {
                minCapacity = capacityDifference;
                suitableAccommodation = accommodation;
            }
        }

        if (suitableAccommodation != null) {
            booking.setStatus(BookingStatus.BOOKED);
            booking.setAccommodation(suitableAccommodation);
            bookings.add(booking);
            bookings.sort(null);
            return suitableAccommodation;
        }
        else {
            booking.setStatus(BookingStatus.REJECTED);
            throw new IllegalStateException("Accommodation is not available");
        }
    }

    public Receipt checkout(Booking b) {
        Receipt r = new Receipt(b, b.getPaymentMethod());

        if (b.getAccommodation() instanceof Room) {
            ((Room) b.getAccommodation()).refillSnacks();
            ((Room) b.getAccommodation()).resetSnackBill();
        }

        bookings.remove(b);
        return r;
    }
}

