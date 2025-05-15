package org.hotelbooking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hotelbooking.core.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static HotelManager mainHotel = new HotelManager();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/org/hotelbooking/controllers/login.fxml"));
        primaryStage.setScene(new Scene(root));

//        double x,y = 0;
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//
//        root.setOnMousePressed(e -> {
//            x = e.getSceneX();
//            y = e.getSceneY();
//        });
//
//        root.setOnMouseDragged(e -> {
//            primaryStage.setX(e.getScreenX() - x);
//            primaryStage.setY(e.getScreenY() - y);
//        });

        primaryStage.setTitle("Hotel Booking");
        primaryStage.show();
    }
}