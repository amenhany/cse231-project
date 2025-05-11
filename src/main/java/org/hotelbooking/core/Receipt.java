package org.hotelbooking.core;

public class Receipt {
    Booking booking;
    PaymentMethod paymentMethod;
    double total;



    @Override
    public String toString() {
        return "Receipt {\n" +
                "  booking=" + booking + ",\n" +
                "  paymentMethod=" + paymentMethod + ",\n" +
                "  total=" +total + "\n" +
                "}";
    }

    public void displayInfo() {
        System.out.println(this.toString());
    }
}
