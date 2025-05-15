package org.hotelbooking.core;

import org.hotelbooking.accommodation.*;

import java.time.LocalDateTime;

public class Booking  implements Comparable<Booking>{
    private Accommodation accommodation;
    private final AccommodationTemplate desiredAccommodation;
    private BookingStatus status;
    private final BoardBasis boardBasis;
    private final Guest[] guests;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final PaymentMethod paymentMethod;


    public Booking(AccommodationTemplate desiredAccommodation, BoardBasis boardBasis, Guest[] guests, LocalDateTime startDate, LocalDateTime endDate, PaymentMethod paymentMethod) {
        this.desiredAccommodation = desiredAccommodation;
        this.boardBasis = boardBasis;
        this.guests = guests;
        this.startDate=startDate;
        this.endDate = endDate;
        this.paymentMethod = paymentMethod;
        status = BookingStatus.PENDING_PAYMENT;
    }

    public PaymentMethod getPaymentMethod() {
        return  paymentMethod;
    }

    public Guest[] getGuests(){
        return guests;
    }

    public LocalDateTime getStartDate() {
        return startDate;
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

    // This method is package-private (default modifier) as we only want the HotelManager class to be able to set
    // the accommodation of a package-private booking object, once it's successfully checked-in.
    void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    // This is also package-private as AccommodationTemplate is mutable, and we do not want to user to modify the
    // desiredAccommodation of a booking object once it's created.
    AccommodationTemplate getDesiredAccommodation() {
        return desiredAccommodation;
    }

    public void setStatus(BookingStatus status){
        if (status != BookingStatus.BOOKED) {
            this.status = status;
        } else {
            System.out.println("Can not cancel booking; it is already booked.");
        }
    }

    public void cancelBooking() {
        if (status == BookingStatus.REJECTED || status == BookingStatus.CANCELLED) {
            System.out.println("Booking is already cancelled");
        }
        else {
            status = BookingStatus.CANCELLED;
        }
    }

    public double calculateBill(){
        double finalBill = accommodation.calculatePrice(startDate, endDate) + boardBasis.getPrice();
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


    @Override
    public int compareTo(Booking o) {
        int comp = this.startDate.compareTo(o.startDate);
        if(comp != 0){        //if start dates not equal
            return comp;
        }
        return this.endDate.compareTo(o.endDate); //if start dates are equal compare end date
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
        System.out.println(this);

        for (int i = 0; i < guests.length; i++){
            System.out.println("Guest "+ i+1 + ": " + guests[i].toString());
        }
    }
}
