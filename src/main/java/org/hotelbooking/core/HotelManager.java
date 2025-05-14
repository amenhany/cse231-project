package org.hotelbooking.core;

import org.hotelbooking.accommodation.Accommodation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    List<Accommodation> accommodations;
    List<Booking> bookings;


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
    }

    public @Nullable  Accommodation checkin(@NotNull Booking booking) {

        if (booking.getEndDate().isBefore(booking.getStartDate())){
            booking.setStatus(BookingStatus.REJECTED);
            throw new IllegalArgumentException("End date cannot be before Start Date");

        }
        if(booking.getStatus() != BookingStatus.CONFIRMED_PAYMENT){
            System.out.println("Payment is not confirmed" );
            booking.setStatus(BookingStatus.REJECTED);
        }
       for (Accommodation accommodation:accommodations){
           if(accommodation.matches(booking.getDesiredAccommodation())
                   && ( booking.getGuests().length <= accommodation.getCapacity() ) ){

               boolean isAvailable=true;
               for(Booking booked: bookings ){
                   if(booked.getAccommodation()==accommodation){
                        if((booking.getStartDate().isAfter(booked.getStartDate()) && booking.getStartDate().isBefore(booked.getEndDate()))
                        || (booking.getEndDate().isAfter(booked.getStartDate()) && booking.getEndDate().isBefore(booked.getEndDate()))){
                            isAvailable=false;
                            break;
                       }

                   }
               }
               if(isAvailable){
                   booking.setStatus(BookingStatus.BOOKED);
                   booking.setAccommodation(accommodation);
                   bookings.add(booking);
                   return accommodation;
               }
           }
       }
        booking.setStatus(BookingStatus.REJECTED);
        System.out.println("Accommodation is not available");

        return null;
    }
    public Receipt checkout(@NotNull Booking booking) {
    return null;
    }
}

