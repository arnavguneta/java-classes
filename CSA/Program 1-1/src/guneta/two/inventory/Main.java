package guneta.two.inventory;

/*
APCS-A PSET 1-1
Arnav Guneta
Period 2
Johns Creek High School
8/30/17 
 */
public class Main {

	public static void main(String[] args) {

		// widgets array which is later passed into the inventory
		Widget widgetListing[] = new Widget[5];
		// heroes instantiated w full, partial, and empty constructor
		Widget superMan = new Widget();
		Widget batMan = new Widget("Batman", "A 3ft tall batman figurine. [MADE IN AMERICA]");
		Widget wonderWoman = new Widget(1.99, 324, 15.55, 19.99, "Wonder Woman",
				"A 2ft tall wonder woman figurine. [MADE IN CHINA]");
		Widget ironMan = new Widget(2.45, 689, 12.99, 16.49, "Ironman",
				"An ironman figurine, made out of plastic. [MADE IN INDONESIA]");
		Widget captainAmerica = new Widget(.99, 199, 9.99, 14.99, "Captain America",
				"Small Captain America figurine made out of rubber and plastic. [MADE IN INDIA]");

		// adds the widgets to the widget array
		widgetListing[0] = superMan;
		widgetListing[1] = batMan;
		widgetListing[2] = wonderWoman;
		widgetListing[3] = ironMan;
		widgetListing[4] = captainAmerica;

		// inventory
		Inventory inventory = new Inventory(widgetListing, "Super Heroes", "An inventory of superhero figurines.");

		// prints out cost of goods produced
		System.out.println("\nThe cost of all produced goods: " + inventory.calculateCOGS() + "\n");
		// prints out expected revenue
		System.out.println("The suggested retail for all items: " + inventory.calculateExpRevenue() + "\n");
		// prints out the profit, COGS - exp. revenue
		System.out.println("Expected profit: " + (inventory.calculateExpRevenue() - inventory.calculateCOGS()) + "\n");

		//  prints the whole inventory
		inventory.printInventory();

	}
}
