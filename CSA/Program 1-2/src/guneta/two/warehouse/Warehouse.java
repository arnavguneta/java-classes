package guneta.two.warehouse;

/*
APCS-A PSET 1-2
Arnav Guneta
Period 2
Johns Creek High School
9/5/17 
 */
public class Warehouse {

	// private fields
	private String name;
	private String street;
	private String city;
	private String state;
	private int zip;
	Inventory[] warehouseSection = new Inventory[3];

	// full constructor
	public Warehouse(String name, String street, String city, String state, int zip, Inventory[] warehouseSection) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.warehouseSection = warehouseSection;
	}

	// partial constructor
	public Warehouse(String name, String street, String city, String state, int zip) {
		for (Inventory element : warehouseSection) {
			element = new Inventory();
		}
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	// empty constructor
	public Warehouse() {
		for (Inventory element : warehouseSection) {
			element = new Inventory();
		}
		this.name = "Name Not Set.";
		this.street = "Street Not Set.";
		this.city = "City Not Set.";
		this.state = "State Not Set";
		this.zip = 00000;
	}

	// setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public Inventory[] getWarehouseSection() {
		return warehouseSection;
	}

	public void setWarehouseSection(Inventory[] warehouseSection) {
		this.warehouseSection = warehouseSection;
	}

	// prints warehouse info
	@Override
	public String toString() {
		return "\nWarehouse Name: " + name + "\n\n" + "_____________________________________________________________________" + "\n\n" + "Warehouse Address: " + street + ", " + city + ", " + state + ", " + zip
				+ "\n" + "_____________________________________________________________________";
	}

	// prints itself
	public void printWarehouseSummary() {
		System.out.println(this.toString());
	}

	// alpha report
	public void printReportAlpha() {
		System.out.println("\n************************************ Warehouse Alpha Report **************************\n"
				+ "**************************************************************************************\n");
		this.printWarehouseSummary();
		System.out.println("\n\nInventories in this warehouse:");
		for (Inventory i : warehouseSection) {
			System.out.println("\n\t" + i.getInventoryName());
		}
		System.out.println("\n\n******************************** End of Warehouse Alpha Report ***********************\n"
				+ "**************************************************************************************\n\n");
	}

	// beta report
	public void printReportBeta() {
		System.out.println("\n*********************************** Warehouse Beta Report **************************\n"
				+ "************************************************************************************\n");
		this.printWarehouseSummary();
		int quantity = 0;
		for (Inventory i : warehouseSection) {
			for (Widget w : i.getInventory()) {
				quantity += w.getInventoryQty();
			}
		}
		System.out.println("\nQuantity of all widgets: " + quantity);
		System.out.println("\n\n******************************* End of Warehouse Beta Report ***********************\n"
				+ "************************************************************************************\n\n");
	}

	// charlie report
	public void printReportCharlie() {
		System.out.println("\n*********************************** Warehouse Charlie Report *************************\n"
				+ "**************************************************************************************\n");		this.printWarehouseSummary();
		for (Inventory i : warehouseSection) {
			i.printInventory();
		}
		System.out.println("\n\n***************************** End of Warehouse Charlie Report **********************\n"
				+ "************************************************************************************\n\n");
	}
}

