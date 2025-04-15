package org.hotelbooking.core;

public class Booking {
    private Accommodation accommodation;

    public Booking() {

    }

    // This method is package-private (default modifier) as we only want the HotelManager class to be able to set
    // the accommodation of a Booking object, once it's successfully checked-in.
    void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
