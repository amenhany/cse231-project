package org.hotelbooking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AccommodationListController {

    @FXML
    AnchorPane parentAnchorPane;

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
