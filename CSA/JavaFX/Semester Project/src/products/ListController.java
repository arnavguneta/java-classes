package products;

/*
APCS-A FINAL PROJECT
Arnav Guneta
Period 2
Johns Creek High School
12/1/2017
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ListController {

	// instance of product controller, the tab node
	private static ProductController pc;
	// edit/ view mode
	private static Mode mode;
	// list indexing
	int index = 0;
	// observable side list
	@FXML private ListView<String> productlist;
	// the tab pane
	@FXML private TabPane productpane;
	// observable list which is fed into the side listView
	private ObservableList<String> obs = FXCollections.observableArrayList();
	// a list of all products
	private List<Product> products = new ArrayList<>();

	public ListController() {

	}

	// called in the product controller, passes the instance
	public static void getProductControllerInstance(ProductController productController) {
		pc = productController;
	}

	public static Mode getMode() {
		return mode;
	}

	public static void setMode(Mode mode) {
		ListController.mode = mode;
	}

	// initializes an empty product
	public void initialize() {
		// starts with view mode
		setMode(Mode.VIEW);

		// sets up the first blank product
		initializeProduct();
		addProductToList();
		openTab(index);
		loadproduct();

		// passes an instance of itself to the product controller
		ProductController.getListControllerInstance(this);
	}

	// called whenever an item in the list view is clicked
	private void loadproduct() {
		// listener for any clicks
		productlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {

				// get the list tab's name
				String value = productlist.getSelectionModel().selectedItemProperty().getValue();

				// Goes through all tabs and if it is already opened, it ignores the rest of this method
				for (Tab tab : productpane.getTabs()) {
					if (tab.getText().equalsIgnoreCase(value)) {
						return;
					}
				}

				//gets the number from the list tab
				int indexFromList = Integer.parseInt(productlist.getSelectionModel().getSelectedItem().split(" ")[1]);
				// opens the tab with the list tab's number
				openTab(indexFromList);
				// if the product already has stuff saved, it loads it
				pc.loadProductFields();
			}

		});

		// clears selection
		productlist.getSelectionModel().clearSelection();

	}

	// after product is initialized, the observable list gets an addition
	public void addProductToList() {
		// index 1 of the string here means index 0 in the obs list
		obs.add("Product " + index);
		// the list of products (left) all get updated with the obs list
		productlist.setItems(obs);
	}

	// open tab from add or click on the list
	public void openTab(int index) {
		// opens the tab with the index
		// index of 1 in the string means index of 0 in obs list, list view, and products list
		try {
			Node node = (AnchorPane) FXMLLoader.load(getClass().getResource("product.fxml"));
			Tab tab = new Tab("Product " + index, node);
			productpane.getTabs().add(tab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// when add is pressed, this method is called to make an empty product and add it to the products list
	public void initializeProduct() {
		Product p = new Product();
		products.add(index, p);
		index++;
	}

	// when the menu item view mode is clicked, this is called
	public void viewMode() {
		setMode(Mode.VIEW);
		// if in view, make the fields not editable
		pc.makeEditable(false);

		// gets the product from products list using the tab index
		int index = Integer.parseInt(productpane.getSelectionModel().getSelectedItem().getText().split(" ")[1]) - 1;
		Product p = products.get(index);

		// sets up the view labels
		pc.initLabels(p);

	}

	// when the menu item edit mode is clicked, this is called
	public void editMode() {
		// edit mode is toggled
		setMode(Mode.EDIT);
		// make everything automatically editable
		pc.makeEditable(true);
		// make the labels disappear
		pc.toggleLabels(false);
		// show the editable text fields
		pc.toggleFields(true);
	}

	public void about() throws Exception{
		// root for the fxml file
		Parent controller = FXMLLoader.load(getClass().getResource("about.fxml"));

		Stage primaryStage = new Stage();
		// sets the title
		primaryStage.setTitle("About");
		// makes the scene with the path to the fxml file and size
		primaryStage.setScene(new Scene(controller, 600, 468));
		// displays the stage
		primaryStage.show();

	}

	// getters and setters
	public ObservableList<String> getObs() {
		return obs;
	}

	public void setObs(ObservableList<String> obs) {
		this.obs = obs;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ListView<String> getProductlist() {
		return productlist;
	}

	public void setProductlist(ListView<String> productlist) {
		this.productlist = productlist;
	}

	public TabPane getProductpane() {
		return productpane;
	}

	public void setProductpane(TabPane productpane) {
		this.productpane = productpane;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
