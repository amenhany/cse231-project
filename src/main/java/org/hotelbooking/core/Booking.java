package org.hotelbooking.core;
import java.time.LocalDateTime;

import static org.hotelbooking.core.BookingStatus.CANCELLED;
import static org.hotelbooking.core.BookingStatus.REJECTED;

public class Booking {
    private Accommodation accommodation;
    private AccommodationTemplate desiredAccommodation;
    private BookingStatus status;
    private BoardBasis boardBasis;
    private int noOfGuests ;
    private Guest guests[] = new Guest[noOfGuests];
    private LocalDateTime startDate ;
    private LocalDateTime endDate ;
    public BookingStatus getStatus(){
        return status ;
    }
    public AccommodationTemplate getDesiredAccommodation() {
        return desiredAccommodation;
    }
    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
    public void cancelBooking(){
        if (status == REJECTED || status == CANCELLED){
            System.out.println("Booking is cancelled.");
        }
    }
    public void displayInfo() {
        System.out.println("Accommodation: "+accommodation);
        System.out.println("Desired Accommodation: "+desiredAccommodation);
        System.out.println("Booking Status: "+status);
        System.out.println("Board Basis: "+boardBasis);
        System.out.println("Start Date: "+startDate);
        System.out.println("End Date: "+endDate);
        for (int i=0;i<noOfGuests;i++){
            System.out.println("Guest "+ i+1 + ": "+guests[i]);
        }
    }
    public double calculateBill(){
        double total=0 ;
        return total;
    }

    public Booking() {

    }

    // This method is package-private (default modifier) as we only want the HotelManager class to be able to set
    // the accommodation of a Booking object, once it's successfully checked-in.


}
