package sample;
/*
APCS-A PSET 3 EXAM
Arnav Guneta
Period 2
Johns Creek High School
11/17/17
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

	// main field text
	int i = 7;
	// side field text
	int n = 1;
	// add button, main field
	@FXML private Button add;
	// sub button, main field
	@FXML private Button sub;
	// increasing button, side field
	@FXML private Button inc;
	// decreasing button, side field
	@FXML private Button dec;
	// main field
	@FXML private TextField lbl;
	// side field
	@FXML private TextField field;
	// error label
	@FXML private Label error;
	// update button
	@FXML private Button update;
	public Controller() {

	}

	// intializes button and field texts that are not static
	@FXML public void initialize() {
		lbl.setText(Integer.toString(i));
		add.setText("ADD " + Integer.toString(n));
		sub.setText("SUB " + Integer.toString(n));
		error.setVisible(false);
	}

	// method called when the main addition button is pressed, it takes text from the main field
	@FXML public void add() {
		i = Integer.parseInt(lbl.getText());
		i = i + n;
		lbl.setText(Integer.toString(i));
	}

	// method called when the main subtraction button is pressed, it takes text from the main field
	@FXML public void sub() {
		i = Integer.parseInt(lbl.getText());
		i = i - n;
		lbl.setText(Integer.toString(i));
	}

	// method called when the side increment button is pressed, it takes text from the side field
	@FXML public void increment() {
		n = Integer.parseInt(field.getText());
		n++;
		field.setText(Integer.toString(n));
	}

	// method called when the side decrement button is pressed, it takes text from the side field
	@FXML public void decrement() {
		n = Integer.parseInt(field.getText());
		n--;
		field.setText(Integer.toString(n));
	}

	// checks if the side views text is in between bounds 37 and -37 and changes the main add/sub buttons
	@FXML public void onUpdate() {
		n = Integer.parseInt(field.getText());

		if (n > 37) {
			n = 37;
			error.setVisible(true);
			field.setText(Integer.toString(n));
		} else if (n < -37) {
			n = -37;
			error.setVisible(true);
			field.setText(Integer.toString(n));
		} else {
			error.setVisible(false);
		}

		add.setText("ADD " + Integer.toString(n));
		sub.setText("SUB " + Integer.toString(n));

	}

}
