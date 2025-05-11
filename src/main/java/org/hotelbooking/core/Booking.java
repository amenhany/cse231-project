package org.hotelbooking.core;

import org.hotelbooking.accommodation.Accommodation;
import org.hotelbooking.accommodation.AccommodationTemplate;

import java.time.LocalDateTime;

public class Booking {
    private Accommodation accommodation;
    private AccommodationTemplate desiredAccommodation;
    private BookingStatus status;
    private BoardBasis boardBasis;
    private Guest[] guests;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    public BookingStatus getStatus(){
        return status ;
    }
    public AccommodationTemplate getDesiredAccommodation() {
        return desiredAccommodation;
    }

    public void cancelBooking() {
        if (status == BookingStatus.REJECTED || status == BookingStatus.CANCELLED) {
            System.out.println("Booking is cancelled.");
        }
        else {
            status = BookingStatus.CANCELLED;
        }
    }

    public double calculateBill(){
        return 0 ;
    }

    // This method is package-private (default modifier) as we only want the HotelManager class to be able to set
    // the accommodation of a Booking object, once it's successfully checked-in.
    void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
    public String toString() {
        return "Accommodation: " + accommodation + "\n" +
                "Booking Status: " + status
                +"\n" +
                "Board Basis: " + boardBasis + "\n" +
                "Start Date: " + startDate + "\n" +
                "End Date: " + endDate;


    }

    public void displayInfo() {
        System.out.println(this.toString());
        for (int i=0;i<guests.length;i++){
            System.out.println("Guest "+ i+1 + ": " + guests[i].toString());
        }

    }
}
