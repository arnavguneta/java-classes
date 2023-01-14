package products;

/*
APCS-A FINAL PROJECT
Arnav Guneta
Period 2
Johns Creek High School
12/1/2017
 */

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductController {

	// instance of the list controller
	private static ListController lc;
	// string wrapper for css (used in empty field error)
	private final ReadOnlyStringWrapper css = new ReadOnlyStringWrapper();
	// a list of all fields
	private List<TextField> fields = new ArrayList<>();

	// edit mode vars
	@FXML private TextField name;
	@FXML private TextField model;
	@FXML private TextField color;
	@FXML private TextField os;
	@FXML private TextField cost;
	@FXML private TextField cap;
	@FXML private TextField size;
	@FXML private TextField weight;
	@FXML private TextField stock;
	@FXML private CheckBox used;

	// view mode vars
	@FXML private Label nameV;
	@FXML private Label modelV;
	@FXML private Label colorV;
	@FXML private Label osV;
	@FXML private Label costV;
	@FXML private Label capV;
	@FXML private Label sizeV;
	@FXML private Label weightV;
	@FXML private Label stockV;
	@FXML private Label usedV;

	// fxml vars
	@FXML private Button delete;
	@FXML private Label error1;

	public ProductController() {

	}

	// called from list controller and accepts its instance
	public static void getListControllerInstance(ListController listController) {
		lc = listController;
	}

	// initializes tab node
	public void initialize() {
		// resets all error messages
		resetErrors();
		// passes its instance to list controller
		ListController.getProductControllerInstance(this);
		// makes everything uneditable by default
		makeEditable(false);
		// clears all field
		clearFields();
		// loads all fields with appropriate values
		loadFields();

	}

	// this is called whenever the add button is pressed
	@FXML public void add() {
		// sets up an empty blank product
		lc.initializeProduct();
		lc.addProductToList();
		lc.openTab(lc.index);

		// if being called from a singular tab, it re-enables the delete button
		if (lc.getProductpane().getTabs().size() == 1) {
			getDelete().setDisable(true);
		} else {
			getDelete().setDisable(false);
		}
	}

	// called when the edit button is pressed
	@FXML private void edit() {
		// makes fields editable
		makeEditable(true);

		// if it is in view mode, hide the labels and show the fields
		if (lc.getMode() == Mode.VIEW) {
			toggleLabels(false);
			toggleFields(true);
		}
	}

	@FXML private void delete() {
		// gets the product from the products list using the tab index
		int index =
				Integer.parseInt(lc.getProductpane().getSelectionModel().getSelectedItem().getText().split(" ")[1]) - 1;
		Product p = lc.getProducts().get(index);

		// if this is the only tab open, disable, otherwise continue
		if (lc.getProductlist().getItems().size() == 1) {
			getDelete().setDisable(true);
			return;
		} else {
			getDelete().setDisable(false);
		}

		// creates an alert with the message specified below and waits for a confirmation
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
				"Are you sure you want to delete '" + lc.getProductpane().getSelectionModel().getSelectedItem()
						.getText() + "'?");

		Optional<ButtonType> result = alert.showAndWait();
		// on confirmation:
		if (result.isPresent() && result.get() == ButtonType.OK) {
			// it removes it from the list and adds a place holder to keep the indexes in check
			lc.getProducts().remove(p);
			lc.getProducts().add(index, new Product());

			// gets the name of the tab being deleted
			String name = lc.getProductpane().getSelectionModel().getSelectedItem().getText();
			// closes the tab
			lc.getProductpane().getTabs().remove(lc.getProductpane().getSelectionModel().getSelectedIndex());

			// from the list view, compare the names with the tab names
			for (String s : lc.getObs()) {
				// if it does match, remove it from the list and update the list view
				if (s.equalsIgnoreCase(name)) {
					lc.getObs().remove(s);
					lc.getProductlist().setItems(lc.getObs());
				}
			}

		}
	}

	// called when save button is pressed
	@FXML private void save() {
		// gets the open tab and get the index[for products list] from there
		int indexFromTab =
				Integer.parseInt(lc.getProductpane().getSelectionModel().getSelectedItem().getText().split(" ")[1]) - 1;
		// loads the product from the products list
		Product p = lc.getProducts().get(indexFromTab);

		// makes the all fields non editable unless in edit mode
		makeEditable(false);

		// resets all errors
		resetErrors();

		// tries to save all values into the product container class
		try {
			p.setName(name.getText());
			p.setModel(model.getText());
			p.setColor(color.getText());
			p.setOs(os.getText());
			p.setCost(Double.parseDouble(cost.getText()));
			p.setCap(Integer.parseInt(cap.getText()));
			p.setSize(Double.parseDouble(size.getText()));
			p.setWeight(Integer.parseInt(weight.getText()));
			p.setStock(Integer.parseInt(stock.getText()));
			p.setUsed(used.isSelected());
		} catch (Exception e) {
			// if save was pressed and some fields were null
			// goes through all fields
			for (TextField field : fields) {
				// if the field is empty, make it red and pop up an error
				if (field.getText().isEmpty()) {
					error1.setVisible(true);
					field.styleProperty().setValue("-fx-background-color: red , white , white; ");
				}
			}
		}

		// if its in view mode, initialize the labels with the new values and display them
		if (lc.getMode() == Mode.VIEW) {
			initLabels(p);
		}
	}

	// toggles all view labels
	public void toggleLabels(Boolean b) {
		nameV.setVisible(b);
		modelV.setVisible(b);
		colorV.setVisible(b);
		osV.setVisible(b);
		costV.setVisible(b);
		capV.setVisible(b);
		sizeV.setVisible(b);
		weightV.setVisible(b);
		stockV.setVisible(b);
		usedV.setVisible(b);
	}

	// toggles all fields
	public void toggleFields(Boolean b) {
		name.setVisible(b);
		model.setVisible(b);
		color.setVisible(b);
		os.setVisible(b);
		cost.setVisible(b);
		cap.setVisible(b);
		size.setVisible(b);
		weight.setVisible(b);
		stock.setVisible(b);
		used.setVisible(b);
	}

	// initializes all labels
	public void initLabels(Product p) {
		// if the product has preset values, then show the labels
		if (lc.getMode() == Mode.VIEW) {
			if (p.getCap() != -9) {
				toggleLabels(true);
				toggleFields(false);
				// sets values for display labels
				nameV.setText(p.getName());
				modelV.setText(p.getModel());
				colorV.setText(p.getColor());
				osV.setText(p.getOs());
				costV.setText("$" + Double.toString(p.getCost()));
				capV.setText(Integer.toString(p.getCap()) + "GB");
				sizeV.setText(Double.toString(p.getSize()) + " inches");
				weightV.setText(Integer.toString(p.getWeight()) + " grams");
				stockV.setText(Integer.toString(p.getStock()));
				usedV.setText("Used: " + Boolean.toString(p.isUsed()));
			} else {
				// if the product doesn't have preset values, meaning it is empty, ask for input
				toggleLabels(false);
				toggleFields(true);
			}
		}

	}

	// toggles the state of the fields
	public void makeEditable(Boolean bool) {
		// if in edit mode, make everything editable
		if (!bool && lc.getMode() == Mode.EDIT)
			bool = true;
		name.setEditable(bool);
		model.setEditable(bool);
		color.setEditable(bool);
		os.setEditable(bool);
		cost.setEditable(bool);
		cap.setEditable(bool);
		size.setEditable(bool);
		weight.setEditable(bool);
		stock.setEditable(bool);
	}

	// called when opened from list tab
	public void loadProductFields() {
		// gets the index from the list
		int indexFromList =
				Integer.parseInt(lc.getProductlist().getSelectionModel().getSelectedItem().split(" ")[1]) - 1;
		// gets the product out from the products list
		Product p = lc.getProducts().get(indexFromList);
		initLabels(p);
		// if its not null, load the saved data
		if (p.getCap() != -9) {
			name.setText(p.getName());
			model.setText(p.getModel());
			color.setText(p.getColor());
			os.setText(p.getOs());
			cost.setText(Double.toString(p.getCost()));
			cap.setText(Integer.toString(p.getCap()));
			size.setText(Double.toString(p.getSize()));
			weight.setText(Integer.toString(p.getWeight()));
			stock.setText(Integer.toString(p.getStock()));
			used.setSelected(p.isUsed());
		}
	}

	// clears all fields
	private void clearFields() {
		name.clear();
		model.clear();
		color.clear();
		os.clear();
		cost.clear();
		cap.clear();
		size.clear();
		weight.clear();
		stock.clear();
	}

	// puts all fields in the field list
	private void loadFields() {
		fields.add(name);
		fields.add(model);
		fields.add(color);
		fields.add(os);
		fields.add(cost);
		fields.add(cap);
		fields.add(size);
		fields.add(weight);
		fields.add(stock);
	}

	// resets all error messages
	private void resetErrors() {
		error1.setVisible(false);
		for (TextField field : fields) {
			field.styleProperty().setValue("");
		}
	}

	// getters and setters
	public Button getDelete() {
		return delete;
	}

	public void setDelete(Button delete) {
		this.delete = delete;
	}
}
