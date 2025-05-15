package org.hotelbooking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    TextField usernameField;
    @FXML
    TextField emailField;

    @FXML
    Label usernameErrorLabel;
    @FXML
    Label emailErrorLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void register(ActionEvent event) throws IOException {

        if (!usernameField.getText().trim().isEmpty() && !emailField.getText().trim().isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/hotelbooking/controllers/home.fxml"));
            root = loader.load();

            HomeController homeController = loader.getController();
            homeController.displayName(usernameField.getText(), emailField.getText());
            homeController.newBookingScene();

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
        }

        if (usernameField.getText().trim().isEmpty()) {
            usernameErrorLabel.setVisible(true);
            usernameField.getStyleClass().add("error-field");
        } else {
            usernameErrorLabel.setVisible(false);
            usernameField.getStyleClass().removeAll("error-field");
        }

        if (emailField.getText().trim().isEmpty()) {
            emailErrorLabel.setVisible(true);
            emailField.getStyleClass().add("error-field");
        } else {
            emailErrorLabel.setVisible(false);
            emailField.getStyleClass().removeAll("error-field");
        }
    }
}
