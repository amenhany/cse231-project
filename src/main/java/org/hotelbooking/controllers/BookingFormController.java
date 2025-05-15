package org.hotelbooking.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.hotelbooking.Main;
import org.hotelbooking.accommodation.*;
import org.hotelbooking.core.*;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class BookingFormController implements Initializable {

    AccommodationTemplate desiredAccommodation;
    Booking booking;

    AccommodationType accommodationType;
    BoardBasis boardBasis;
    LocalDateTime startDate;
    LocalDateTime endDate;
    PaymentMethod paymentMethod;
    int numberOfGuests;
    int minNumberOfRooms;


    @FXML
    ToggleGroup paymentMethodGroup;

    @FXML
    ChoiceBox<AccommodationType> accommodationTypeChoiceBox;
    @FXML
    ChoiceBox<BoardBasis> boardBasisChoiceBox;
    @FXML
    DatePicker startDateField;
    @FXML
    DatePicker endDateField;
    @FXML
    RadioButton visaRadioButton;
    @FXML
    RadioButton cashRadioButton;
    @FXML
    TextField guestField;

    // Optional features
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
        boardBasisChoiceBox.getItems().addAll(BoardBasis.values());
        roomViewChoiceBox.getItems().addAll(RoomView.values());

        roomViewChoiceBox.setVisible(false);
        roomViewLabel.setVisible(false);
        numberOfRoomsLabel.setVisible(false);
        numberOfRoomsField.setVisible(false);

        accommodationTypeChoiceBox.setOnAction(event -> {
            numberOfRoomsLabel.setVisible(false);
            numberOfRoomsField.setVisible(false);
            firstOption.setVisible(false);
            secondOption.setVisible(false);
            roomViewChoiceBox.setVisible(false);
            roomViewLabel.setVisible(false);

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
            }
            if(accommodationTypeChoiceBox.getValue() == AccommodationType.SINGLE_ROOM || accommodationTypeChoiceBox.getValue() == AccommodationType.DOUBLE_ROOM
            || accommodationTypeChoiceBox.getValue() == AccommodationType.SUITE) {
                roomViewChoiceBox.setVisible(true);
                roomViewLabel.setVisible(true);
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

        // Check board basis is chosen
        if (boardBasisChoiceBox.getValue() != null) {
            boardBasis = boardBasisChoiceBox.getValue();
            boardBasisChoiceBox.getStyleClass().removeAll("error-field");
        } else {
            errorFlag = true;
            errorLabel.setText("Please select a board basis");
            boardBasisChoiceBox.getStyleClass().add("error-field");
        }

        // Check start date is after now
        if ((startDateField.getValue() == null) || (startDateField.getValue().atTime(11, 0).isBefore(LocalDateTime.now()))) {
            errorLabel.setText("Please enter a valid starting date");
            errorFlag = true;
            startDateField.getStyleClass().add("error-field");
        } else {
            startDateField.getStyleClass().removeAll("error-field");
            startDate = startDateField.getValue().atTime(13, 0);
        }

        // Check end date is after start date
        if ((endDateField.getValue() == null) || (endDateField.getValue().atTime(11, 0).isBefore(startDate != null ? startDate : LocalDateTime.now()))) {
            errorLabel.setText("Please enter a valid end date");
            errorFlag = true;
            endDateField.getStyleClass().add("error-field");
        } else {
            endDateField.getStyleClass().removeAll("error-field");
            endDate = endDateField.getValue().atTime(13, 0);
        }

        // Check guest number is an integer
        try {
            numberOfGuests = Integer.parseInt(guestField.getText());
            guestField.getStyleClass().removeAll("error-field");
        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter integers only in the Number of Guests");
            errorFlag = true;
            guestField.getStyleClass().add("error-field");
        }

        // Set the payment method
        if (visaRadioButton.isSelected()) {
            paymentMethod = PaymentMethod.VISA;
        } else if (cashRadioButton.isSelected()) {
            paymentMethod = PaymentMethod.CASH;
        } else {
            errorFlag = true;
            errorLabel.setText("Please select a payment method");
        }


        if (errorFlag) {
            errorLabel.setVisible(true);
            return;
        }
        else {
            errorLabel.setVisible(false);
        }


        /* ####################### Make a Booking ####################### */

        desiredAccommodation = new AccommodationTemplate(accommodationType);

        if (accommodationType == AccommodationType.SINGLE_ROOM || accommodationType == AccommodationType.DOUBLE_ROOM
        || accommodationType == AccommodationType.SUITE) {
            errorLabel.setText("Please select a room view");
            if (roomViewChoiceBox.getValue() == null) {
                errorLabel.setVisible(true);
                roomViewChoiceBox.getStyleClass().add("error-field");
                return;
            }
            roomViewChoiceBox.getStyleClass().removeAll("error-field");
            desiredAccommodation.setView(roomViewChoiceBox.getValue());
        }

        if (accommodationType == AccommodationType.CHALET) {
            // Check number of rooms field is not empty
            try {
                minNumberOfRooms = Integer.parseInt(numberOfRoomsField.getText());
                numberOfRoomsField.getStyleClass().removeAll("error-field");
            } catch (NumberFormatException ex) {
                errorLabel.setText("Please enter integers only in the Number of Guests");
                errorLabel.setVisible(true);
                numberOfRoomsField.getStyleClass().add("error-field");
                return;
            }
            desiredAccommodation.setMinimumNumberOfRooms(minNumberOfRooms);
        }
        else if (accommodationType == AccommodationType.DOUBLE_ROOM) {
            desiredAccommodation.setIsBedKingSize(firstOption.isSelected());
            if (numberOfGuests > 2) {
                errorLabel.setText("Double rooms hold one or two guests");
                errorLabel.setVisible(true);
                numberOfRoomsField.getStyleClass().add("error-field");
                return;
            }
        }
        else if (accommodationType == AccommodationType.VILLA) {
            desiredAccommodation.setHasPool(firstOption.isSelected());
        }
        else if (accommodationType == AccommodationType.SUITE) {
            desiredAccommodation.setHasJacuzzi(firstOption.isSelected());
            desiredAccommodation.setHasEnsuiteBathroom(secondOption.isSelected());
        }
        if (accommodationType == AccommodationType.SINGLE_ROOM) {
            if (numberOfGuests > 1) {
                errorLabel.setText("Single rooms hold only one guest");
                errorLabel.setVisible(true);
                numberOfRoomsField.getStyleClass().add("error-field");
                return;
            }
        }

        try {
            booking = new Booking(desiredAccommodation, boardBasis, new Guest[numberOfGuests], startDate, endDate, paymentMethod);
            booking.setStatus(BookingStatus.CONFIRMED_PAYMENT);
            Main.mainHotel.checkin(booking);
        } catch (IllegalStateException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Error Booking");
            alert.setContentText("No suitable accommodation is available at the moment");
            alert.showAndWait();
        }
    }
}
