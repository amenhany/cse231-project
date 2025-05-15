package org.hotelbooking.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.hotelbooking.core.Booking;

import java.net.URL;
import java.util.ResourceBundle;

public class BookingItemController {

    @FXML
    Label accommodationId;
    @FXML
    Label date;
    @FXML
    Label totalBill;

    public void displayInfo(Booking booking) {
        accommodationId.setText(booking.getAccommodation().getClass().getName().substring(31).replaceAll("(.)([A-Z])", "$1 $2") + " (" + booking.getAccommodation().getAccommodationId().substring(2) + ")");
        date.setText(booking.getStartDate() + " - " + booking.getEndDate());
        totalBill.setText(String.format("$%.2f", booking.calculateBill()));
    }
}
