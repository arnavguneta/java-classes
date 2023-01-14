package guneta.two.warehouse;

import static java.lang.Math.round;

/*
APCS-A PSET 1-2
Arnav Guneta
Period 2
Johns Creek High School
9/5/17
 */
public class Inventory {

	// field variables
	private Widget inventory[] = new Widget[5];
	private String inventoryName;
	private String inventoryDescription;

	//Default Constructor
	public Inventory() {
		for (Widget element : inventory) {
			element = new Widget();
		}
		inventoryName = "No Inventory Name Assigned.";
		inventoryDescription = "No Inventory Description Assigned";
	}

	//Full Constructor
	public Inventory(Widget[] inven, String name, String desc) {
		inventory = inven;
		inventoryName = name;
		inventoryDescription = desc;
	}

	//Partial Constructor
	public Inventory(String name, String desc) {
		for (Widget element : inventory) {
			element = new Widget();
		}
		inventoryName = name;
		inventoryDescription = desc;
	}

	//Getters and Setters
	public Widget[] getInventory() {
		return inventory;
	}

	public void setInventory(Widget[] inventory) {
		this.inventory = inventory;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getInventoryDescription() {
		return inventoryDescription;
	}

	public void setInventoryDescription(String inventoryDescription) {
		this.inventoryDescription = inventoryDescription;
	}

	//Class Methods

	// prints out the inventories name and its description
	@Override public String toString() {
		return "\n\t\t\tInventory\n\nInventory Name: " + getInventoryName() + "\n\nInventory Description: "
				+ getInventoryDescription() + "";
	}

	// calculates cost of all goods produced
	public double calculateCOGS() {
		double cop = 0;
		for (Widget element : inventory) {
			cop += element.getProductionCost() * element.getInventoryQty();
		}
		return cop;
	}

	// calculates money earned from all things sold
	public double calculateExpRevenue() {
		double sugRetail = 0;
		for (Widget element : inventory) {
			sugRetail += element.getSuggestedRetail() * element.getInventoryQty();
		}
		return sugRetail;
	}

	// prints the whole inventory with its widgets
	public void printInventory() {
		System.out.println(this.toString());

		System.out.println("\n" + "_____________________________________________________________________" + "\n");
		// prints out cost of goods produced
		System.out.println("\nThe cost of all produced goods: $" + (float) this.calculateCOGS() + "\n");
		// prints out expected revenue
		System.out.println("The suggested retail for all items: $" + (float) this.calculateExpRevenue() + "\n");
		// prints out the profit, COGS - exp. revenue
		System.out.println("Expected profit: $" + (float) (this.calculateExpRevenue() - this.calculateCOGS()) + "\n");
		System.out.println("\n" + "_____________________________________________________________________" + "\n");



		for (Widget element : inventory) {
			System.out.println(element.toString());
		}
	}

}

