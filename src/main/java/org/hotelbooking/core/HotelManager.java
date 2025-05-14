package org.hotelbooking.core;

import org.hotelbooking.accommodation.Accommodation;
import org.hotelbooking.accommodation.ConferenceRoom;
import org.hotelbooking.accommodation.Room;

import java.util.List;

public class HotelManager {


    List<Accommodation> accommodations;
    List<Booking> bookings;

    public void addAccommodation(Accommodation accommodation) {
        if (accommodation != null) {
            accommodations.add(accommodation);
        }
    }

    public Accommodation checkin(Booking booking) {

        return null;
    }


    public Receipt checkout(Booking b) {
        if (b.getAccommodation() instanceof Room) {
            ((Room) b.getAccommodation()).refillSnacks();
        }
        Receipt r = new Receipt(b, b.getPaymentMethod());
        bookings.remove(b);
        return r;
    }
}


