package org.hotelbooking.core;

import org.hotelbooking.accommodation.Accommodation;
import org.jetbrains.annotations.NotNull;

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

    public Accommodation checkin(@NotNull Booking booking) {
        if (booking.getEndDate().isBefore(booking.getStartDate())){
            throw new IllegalArgumentException("End date cannot be before Start Date");
        }
        if(booking.getStatus() != BookingStatus.CONFIRMED_PAYMENT){
            System.out.println("Payment is not confirmed");
        }
        if (booking.getAccommodation().getCapacity()){

        }
    }
    public Receipt checkout(@NotNull Booking booking) {

    }
}

