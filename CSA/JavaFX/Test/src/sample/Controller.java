package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

	@FXML private Button switchScene;

	@FXML private AnchorPane ap;

	public void scene2() {
		Stage stage = (Stage) ap.getScene().getWindow();

		try {
			Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
			stage.setScene(new Scene(root, 300, 275));
			stage.show();
		} catch (Exception e) {
			System.out.println("Error");
		}

	}

}
