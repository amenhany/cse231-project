package org.hotelbooking.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.hotelbooking.Main;
import org.hotelbooking.accommodation.*;
import org.hotelbooking.core.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccommodationFormController implements Initializable {

    Accommodation accommodation;

    AccommodationType accommodationType;
    int accommodationNumber;
    double pricePerNight;
    int capacity;
    RoomView roomView;
    int numberOfRooms;


    @FXML
    AnchorPane parentAnchorPane;

    @FXML
    ChoiceBox<AccommodationType> accommodationTypeChoiceBox;
    @FXML
    TextField accommodationNumberField;
    @FXML
    TextField priceField;
    @FXML
    Label priceLabel;

    // Optional features
    @FXML
    TextField capacityField;
    @FXML
    Label capacityLabel;
    @FXML
    TextField numberOfRoomsField;
    @FXML
    Label numberOfRoomsLabel;
    @FXML
    CheckBox firstOption;
    @FXML
    CheckBox secondOption;
    @FXML
    ChoiceBox<RoomView> roomViewChoiceBox;
    @FXML
    Label roomViewLabel;

    @FXML
    Label errorLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accommodationTypeChoiceBox.getItems().addAll(AccommodationType.values());
        roomViewChoiceBox.getItems().addAll(RoomView.values());

        roomViewChoiceBox.setVisible(false);
        roomViewLabel.setVisible(false);
        numberOfRoomsLabel.setVisible(false);
        numberOfRoomsField.setVisible(false);
        capacityField.setVisible(true);
        capacityLabel.setVisible(true);

        accommodationTypeChoiceBox.setOnAction(event -> {
            numberOfRoomsLabel.setVisible(false);
            numberOfRoomsField.setVisible(false);
            firstOption.setVisible(false);
            secondOption.setVisible(false);
            roomViewChoiceBox.setVisible(false);
            roomViewLabel.setVisible(false);
            capacityField.setVisible(true);
            capacityLabel.setVisible(true);
            priceLabel.setText("Price / Night");

            if(accommodationTypeChoiceBox.getValue() == AccommodationType.CHALET) {
                numberOfRoomsField.setVisible(true);
                numberOfRoomsLabel.setVisible(true);
            }
            else if(accommodationTypeChoiceBox.getValue() == AccommodationType.VILLA) {
                firstOption.setText("Pool");
                firstOption.setVisible(true);
            }
            else if(accommodationTypeChoiceBox.getValue() == AccommodationType.DOUBLE_ROOM) {
                firstOption.setText("King-sized Bed");
                firstOption.setVisible(true);
            }
            else if(accommodationTypeChoiceBox.getValue() == AccommodationType.SUITE) {
                firstOption.setText("Jacuzzi");
                firstOption.setVisible(true);
                secondOption.setText("Ensuite Bathroom");
                secondOption.setVisible(true);

                roomViewChoiceBox.setVisible(true);
                roomViewLabel.setVisible(true);
            }
            else if(accommodationTypeChoiceBox.getValue() == AccommodationType.CONFERENCE_ROOM) {
                priceLabel.setText("Hourly Rate");
                firstOption.setText("Projector");
                firstOption.setVisible(true);
            }

            if(accommodationTypeChoiceBox.getValue() == AccommodationType.SINGLE_ROOM || accommodationTypeChoiceBox.getValue() == AccommodationType.DOUBLE_ROOM) {
                roomViewChoiceBox.setVisible(true);
                roomViewLabel.setVisible(true);

                capacityField.setVisible(false);
                capacityLabel.setVisible(false);
            }
        });
    }


    public void onSubmit() {

        boolean errorFlag = false;

        /* ####################### Validation Checks ####################### */


        // Check accommodation is chosen
        if (accommodationTypeChoiceBox.getValue() != null) {
            accommodationType = accommodationTypeChoiceBox.getValue();
            accommodationTypeChoiceBox.getStyleClass().removeAll("error-field");
        } else {
            errorFlag = true;
            errorLabel.setText("Please select a type of accommodation");
            accommodationTypeChoiceBox.getStyleClass().add("error-field");
        }

        // Check accommodation number is a number
        try {
            accommodationNumber = Integer.parseInt(accommodationNumberField.getText());
            accommodationNumberField.getStyleClass().removeAll("error-field");
        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter a valid Accommodation Number");
            errorFlag = true;
            accommodationNumberField.getStyleClass().add("error-field");
        }

        // Check price per night is a double
        try {
            pricePerNight = Double.parseDouble(priceField.getText());
            priceField.getStyleClass().removeAll("error-field");
        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter a valid price");
            errorFlag = true;
            priceField.getStyleClass().add("error-field");
        }

        // Check room view is chosen for rooms
        if (accommodationType == AccommodationType.SINGLE_ROOM || accommodationType == AccommodationType.DOUBLE_ROOM
        || accommodationType == AccommodationType.SUITE) {
            if (roomViewChoiceBox.getValue() == null) {
                errorFlag = true;
                errorLabel.setText("Please select a room view");
                roomViewChoiceBox.getStyleClass().add("error-field");
            } else {
                roomView = roomViewChoiceBox.getValue();
                roomViewChoiceBox.getStyleClass().removeAll("error-field");
            }
        }

        if (errorFlag) {
            errorLabel.setVisible(true);
            return;
        }
        else {
            errorLabel.setVisible(false);
        }


        /* ####################### Make an Accommodation ####################### */

        if (accommodationType == AccommodationType.SINGLE_ROOM) {
            accommodation = new SingleRoom(accommodationNumber, pricePerNight, roomView);
        }
        else if (accommodationType == AccommodationType.DOUBLE_ROOM) {
            accommodation = new DoubleRoom(accommodationNumber, pricePerNight, roomView, firstOption.isSelected());
        }
        else {
            // Check capacity is an int
            try {
                capacity = Integer.parseInt(capacityField.getText());
                capacityField.getStyleClass().removeAll("error-field");
            } catch (NumberFormatException ex) {
                errorLabel.setText("Please enter a valid capacity");
                errorLabel.setVisible(true);
                capacityField.getStyleClass().add("error-field");
            }

            if (accommodationType == AccommodationType.CHALET) {
                // Check number of rooms field is not empty
                try {
                    numberOfRooms = Integer.parseInt(numberOfRoomsField.getText());
                    numberOfRoomsField.getStyleClass().removeAll("error-field");
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Please enter integers only in the Number of Guests");
                    errorLabel.setVisible(true);
                    numberOfRoomsField.getStyleClass().add("error-field");
                    return;
                }
                accommodation = new Chalet(accommodationNumber, pricePerNight, capacity, numberOfRooms);
            }
            else if (accommodationType == AccommodationType.VILLA) {
                accommodation = new Villa(accommodationNumber, pricePerNight, capacity, firstOption.isSelected());
            }
            else if (accommodationType == AccommodationType.SUITE) {
                accommodation = new Suite(accommodationNumber, pricePerNight, capacity, roomView, firstOption.isSelected(), secondOption.isSelected());
            }
            else if (accommodationType == AccommodationType.CONFERENCE_ROOM) {
                accommodation = new ConferenceRoom(accommodationNumber, pricePerNight, firstOption.isSelected());
            }
        }

        try {
            Main.mainHotel.addAccommodation(accommodation);

            try {
                AnchorPane content = FXMLLoader.load(getClass().getResource("/org/hotelbooking/controllers/accommodationList.fxml"));

                AnchorPane.setTopAnchor(content, 0.0);
                AnchorPane.setBottomAnchor(content, 0.0);
                AnchorPane.setLeftAnchor(content, 0.0);
                AnchorPane.setRightAnchor(content, 0.0);

                parentAnchorPane.getChildren().setAll(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Error adding Accommodation");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
}
