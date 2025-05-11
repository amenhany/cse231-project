package org.hotelbooking.core;

import org.hotelbooking.accommodation.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public class Booking  implements Comparable<Booking>{
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
        double finalBill = accommodation.calculatePrice(startDate, endDate);
        if(accommodation instanceof ExtraFeeApplicable){
          finalBill += ((ExtraFeeApplicable) accommodation).getExtraFees();
        }
        if(accommodation instanceof Room){
          finalBill += ((Room) accommodation).getSnackBill();
        }
        if(accommodation instanceof Offerable){
          finalBill -= ((Offerable) accommodation).getDiscount();
        }
        return finalBill;

    }

    // This method is package-private (default modifier) as we only want the HotelManager class to be able to set
    // the accommodation of a Booking object, once it's successfully checked-in.
    void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public void displayInfo() {
        System.out.println("Accommodation: " + accommodation + "\nDesired Accommodation: " + desiredAccommodation + "\nBooking Status: " + status
                +"\nBoard Basis: " + boardBasis + "\nStart Date: " + startDate + "\nEnd Date: " + endDate);

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
