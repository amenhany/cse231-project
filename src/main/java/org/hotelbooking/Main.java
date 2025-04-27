package org.hotelbooking;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.hotelbooking.core.*;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button btOK = new Button("OK"); // create a button
        Scene scene = new Scene(btOK, 200, 250); // create a scene WITH the button
        stage.setTitle("MyJavaFX"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show();
    }
}