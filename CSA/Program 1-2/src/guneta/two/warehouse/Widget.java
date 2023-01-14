package guneta.two.warehouse;

/*
APCS-A PSET 1-2
Arnav Guneta
Period 2
Johns Creek High School
9/5/17 
 */
public class Widget {

	// filed variables
	private double productionCost;
	private int inventoryQty;
	private double wholesalePrice;
	private double suggestedRetail;
	private String widgetName;
	private String widgetDescription;

	// empty constructor calls the full constructor to set up the variables
	public Widget() {
		this(0, 0, 0, 0, "No Name Set", "No Description Set");

	}

	// full constructor
	public Widget(double prCost, int invQty, double wholePrice, double sugRetail, String name, String desc) {
		productionCost = prCost;
		inventoryQty = invQty;
		wholesalePrice = wholePrice;
		suggestedRetail = sugRetail;
		widgetName = name;
		widgetDescription = desc;
	}

	// partial constructor, calls full constructor
	public Widget(String name, String desc) {
		this(0, 0, 0, 0, name, desc);
	}

	//Getters and Setters

	//Read Write

	public int getInventoryQty() {
		return inventoryQty;
	}

	public void setInventoryQty(int inventoryQty) {
		this.inventoryQty = inventoryQty;
	}

	public double getSuggestedRetail() {
		return suggestedRetail;
	}

	public void setSuggestedRetail(double suggestedRetail) {
		this.suggestedRetail = suggestedRetail;
	}

	public String getWidgetName() {
		return widgetName;
	}

	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}

	public String getWidgetDescription() {
		return widgetDescription;
	}

	public void setWidgetDescription(String widgetDescription) {
		this.widgetDescription = widgetDescription;
	}

	//Read Only!!!

	public double getProductionCost() {
		return productionCost;
	}

	public double getWholesalePrice() {
		return wholesalePrice;
	}

	//Method ToString()
	@Override public String toString() {

		return "\n\n************************************ Widget Part Report *************************\n"
				+ "*********************************************************************************\n"
				+ "\nWidget Name: " + widgetName + "\n" + "Description: " + widgetDescription + "\n"
				+ "_______________________________________________" + "\n" + "\nWidget Cost of Goods Sold: "
				+ productionCost + "\n" + "Widget WholeSale Revenue: " + wholesalePrice + "\n"
				+ "Widget Suggested Retail : " + suggestedRetail + "\n\n"
				+ "_______________________________________________" + "\n" + "\nQuantity in Warehouse: " + inventoryQty
				+ "\n" + "_______________________________________________" + "\n\n";

	}

}

