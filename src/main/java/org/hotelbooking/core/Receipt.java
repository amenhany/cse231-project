package org.hotelbooking.core;

import org.jetbrains.annotations.NotNull;

public class Receipt {
    Booking booking;
    PaymentMethod paymentMethod;
    double total;


    Receipt(@NotNull Booking booking, PaymentMethod paymentMethod) {
        this.booking=booking;
        this.paymentMethod=paymentMethod;
        total = booking.calculateBill();
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Receipt {\n" +
                "  booking=" + booking + ",\n" +
                "  paymentMethod=" + paymentMethod + ",\n" +
                "  total=" +total + "\n" +
                "}";
    }

    public void displayInfo() {
        System.out.println(this);
    }
}
