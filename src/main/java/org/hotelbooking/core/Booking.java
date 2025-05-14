package org.hotelbooking.core;

import org.hotelbooking.accommodation.Accommodation;
import org.hotelbooking.accommodation.AccommodationTemplate;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public class Booking  implements Comparable<Booking>{
    private Accommodation accommodation;
    private final AccommodationTemplate desiredAccommodation;
    private BookingStatus status;
    private final BoardBasis boardBasis;
    private final Guest[] guests;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;


    public Booking(AccommodationTemplate desiredAccommodation,BoardBasis boardBasis , Guest[] guests,LocalDateTime startDate,LocalDateTime endDate){
        this.desiredAccommodation = desiredAccommodation;
        this.boardBasis = boardBasis;
        this.guests = guests;
        this.startDate=startDate;
        this.endDate = endDate;
        status = BookingStatus.PENDING_PAYMENT;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Guest[] getGuests() {
        return guests;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BookingStatus getStatus(){
        return status ;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    AccommodationTemplate getDesiredAccommodation() {
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

    // This method is p(default modifier) as we only want the HotelManager class to be able to set
    // the accommodation of a Boackage-private oking object, once it's successfully checked-in.
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

    @Override
    public int compareTo(Booking o) {
       int comp= this.startDate.compareTo(o.startDate);
      if(comp != 0){        //if start dates not equal
          return comp;
      }
      return this.endDate.compareTo(o.endDate); //if start dates are equal compare end date

    }
}
