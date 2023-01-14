package products;

/*
APCS-A FINAL PROJECT
Arnav Guneta
Period 2
Johns Creek High School
12/1/2017
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override public void start(Stage primaryStage) throws Exception {
		// root for the fxml file
		Parent controller = FXMLLoader.load(getClass().getResource("list.fxml"));
		// sets the title
		primaryStage.setTitle("Product Manager");
		// makes the scene with the path to the fxml file and size
		primaryStage.setScene(new Scene(controller, 624, 480));
		// displays the stage
		primaryStage.show();
	}
}
