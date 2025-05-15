package org.hotelbooking.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.hotelbooking.accommodation.*;

public class AccommodationItemController {

    @FXML
    Label accommodationId;
    @FXML
    Label price;
    @FXML
    Label capacity;
    @FXML
    Label extraFeatures;

    public void displayInfo(Accommodation accommodation) {
        String extraFeaturesString = "";

        accommodationId.setText(accommodation.getClass().getName().substring(31).replaceAll("(.)([A-Z])", "$1 $2") + " (" + accommodation.getAccommodationId().substring(2) + ")");
        if (accommodation instanceof ConferenceRoom) {
            price.setText(String.format("$%.2f", ((ConferenceRoom) accommodation).getHourlyRate()) + " / Hour");
        } else {
            price.setText(String.format("$%.2f", accommodation.getPricePerNight()) + " / Night");
        }

        capacity.setText("Capacity: " + accommodation.getCapacity());

        if (accommodation instanceof Room) {
            extraFeaturesString += ((Room) accommodation).getView();
        }

        extraFeatures.setText(extraFeaturesString);
    }
}
