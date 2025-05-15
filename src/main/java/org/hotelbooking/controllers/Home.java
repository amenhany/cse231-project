package org.hotelbooking.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class Home {


    @FXML
    private AnchorPane contentArea;
    @FXML
    private void loadNewPane() {
        try {
            AnchorPane newPane = FXMLLoader.load(getClass().getResource("bookingsPane.fxml"));
            contentArea.getChildren().setAll(newPane); // replaces current content
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

