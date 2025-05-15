package org.hotelbooking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.hotelbooking.Main;
import org.hotelbooking.core.Booking;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookingListController implements Initializable {

    private static List<Booking> myBookings;

    @FXML
    AnchorPane parentAnchorPane;
    @FXML
    VBox list;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myBookings = Main.mainHotel.getBookingsByEmail(HomeController.getEmail());
        if (!myBookings.isEmpty()) list.getChildren().removeAll(list.getChildren().get(0));

        for (Booking booking : myBookings) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/hotelbooking/controllers/bookingItem.fxml"));
                AnchorPane content = loader.load();

                AnchorPane.setTopAnchor(content, 0.0);
                AnchorPane.setBottomAnchor(content, 0.0);
                AnchorPane.setLeftAnchor(content, 0.0);
                AnchorPane.setRightAnchor(content, 0.0);

                BookingItemController bookingItemController = loader.getController();
                bookingItemController.displayInfo(booking);

                list.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Booking> getMyBookings() {
        return myBookings;
    }

    public void newBookingScene(ActionEvent event) {
        try {
            AnchorPane content = FXMLLoader.load(getClass().getResource("/org/hotelbooking/controllers/bookingForm.fxml"));

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
