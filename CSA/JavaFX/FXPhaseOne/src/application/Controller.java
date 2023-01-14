package application;

/*
APCS-A PSET 3-4
Arnav Guneta
Period 2
Johns Creek High School
11/13/17
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

	public Controller() {

	}

	// main label
	@FXML
	private Label lbl;

	// value in the label
	@FXML
	private int value = 7;

	// method called when add is pressed
	@FXML
	private void add() {
		value++;
		lbl.setText(Integer.toString(value));
	}

	// method called when sub is pressed
	@FXML
	private void sub() {
		value--;
		lbl.setText(Integer.toString(value));
	}

	// method called when the program is ran
	@FXML
	public void initialize() {
		lbl.setText(Integer.toString(value));
		lbl.setVisible(true);
	}
}
