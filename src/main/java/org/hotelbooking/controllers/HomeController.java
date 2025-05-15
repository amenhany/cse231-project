package org.hotelbooking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hotelbooking.core.HotelManager;

import java.io.IOException;

public class HomeController {

    @FXML
    Text username;

    @FXML
    Pane mainPane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button newBookingButton;
    @FXML
    Button bookingsButton;
    @FXML
    Button accommodationsButton;

    public void displayName(String username) {
        this.username.setText(username);
    }

    public void handleLogout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/hotelbooking/controllers/login.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            double oldCenterX = stage.getX() + stage.getWidth() / 2;
            double oldCenterY = stage.getY() + stage.getHeight() / 2;

            scene = new Scene(root);
            stage.setScene(scene);

            stage.sizeToScene();
            double newX = oldCenterX - stage.getWidth() / 2;
            double newY = oldCenterY - stage.getHeight() / 2;
            stage.setX(newX);
            stage.setY(newY);

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void newBookingScene() {
        try {
            AnchorPane content = FXMLLoader.load(getClass().getResource("/org/hotelbooking/controllers/bookingForm.fxml"));

            AnchorPane.setTopAnchor(content, 0.0);
            AnchorPane.setBottomAnchor(content, 0.0);
            AnchorPane.setLeftAnchor(content, 0.0);
            AnchorPane.setRightAnchor(content, 0.0);

            mainPane.getChildren().setAll(content);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void bookingsScene() {

    }

    public void accommodationsScene() {

    }
}
