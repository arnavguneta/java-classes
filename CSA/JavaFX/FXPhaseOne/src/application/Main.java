package application;

/*
APCS-A PSET 3-4
Arnav Guneta
Period 2
Johns Creek High School
11/13/17
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // root for fxml file
        Parent root = FXMLLoader.load(Main.class.getResource("layout.fxml"));
        // sets title
        primaryStage.setTitle("FXPhaseOne");
        // makes the scene with the path to the fxml path and size
        primaryStage.setScene(new Scene(root, 600, 350));
        // shows the stage
        primaryStage.show();
    }

    // sets up javafx
    public static void main(String[] args) {
        launch(args);
    }
}
