package org.hotelbooking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.hotelbooking.accommodation.Accommodation;
import org.hotelbooking.core.Booking;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class AccommodationListController implements Initializable {

    private static List<Accommodation> myAccommodations;

    @FXML
    AnchorPane parentAnchorPane;
    @FXML
    VBox list;
    @FXML
    Button addAccommodationButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Set accommodationSet = new HashSet<>();

        if (HomeController.getEmail().equalsIgnoreCase("admin@hotelbooking.org")) addAccommodationButton.setVisible(true);

        if (BookingListController.getMyBookings() != null) {
            if (!BookingListController.getMyBookings().isEmpty()) list.getChildren().removeAll(list.getChildren().get(0));
            for (Booking booking : BookingListController.getMyBookings()) {
                accommodationSet.add(booking.getAccommodation());
            }
            myAccommodations = (ArrayList<Accommodation>)accommodationSet.stream()
                    .collect(Collectors.toList());
            myAccommodations.sort(null);

            for (Accommodation accommodation : myAccommodations) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/hotelbooking/controllers/accommodationItem.fxml"));
                    AnchorPane content = loader.load();

                    AnchorPane.setTopAnchor(content, 0.0);
                    AnchorPane.setBottomAnchor(content, 0.0);
                    AnchorPane.setLeftAnchor(content, 0.0);
                    AnchorPane.setRightAnchor(content, 0.0);

                    AccommodationItemController accommodationItemController = loader.getController();
                    accommodationItemController.displayInfo(accommodation);

                    list.getChildren().add(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void newAccommodationScene(ActionEvent event) {
        try {
            AnchorPane content = FXMLLoader.load(getClass().getResource("/org/hotelbooking/controllers/accommodationForm.fxml"));

            AnchorPane.setTopAnchor(content, 0.0);
            AnchorPane.setBottomAnchor(content, 0.0);
            AnchorPane.setLeftAnchor(content, 0.0);
            AnchorPane.setRightAnchor(content, 0.0);

            parentAnchorPane.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
