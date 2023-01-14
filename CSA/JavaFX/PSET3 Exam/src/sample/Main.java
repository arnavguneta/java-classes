package sample;

/*
APCS-A PSET 3 EXAM
Arnav Guneta
Period 2
Johns Creek High School
11/17/17
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // root for fxml file
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        // sets title
        primaryStage.setTitle("PSET 3 EXAM");
        // makes the scene with the path to the fxml path and size
        Scene scene = new Scene(root, 600, 335);
        primaryStage.setScene(scene);
        // shows the stage
        primaryStage.show();

        URL iconURL = Main.class.getResource("icon.png");
        Image image = new ImageIcon(iconURL).getImage();
        com.apple.eawt.Application.getApplication().setDockIconImage(image);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
