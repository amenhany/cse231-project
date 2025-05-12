package org.hotelbooking.core;

import org.hotelbooking.accommodation.Accommodation;

import java.util.List;

public class HotelManager {


    List<Accommodation> accommodations;
    List<Booking>bookings;

    public void addAccommodation(Accommodation accommodation) {
        if (accommodation != null) {
            accommodations.add(accommodation);
        }
    }

    public Accommodation checkin(Booking booking) {

        return null;
    }
    public Receipt checkout(Booking booking) {

        return null; // Booking not found
    }
}

