package guneta.two.warehouse;

/*
APCS-A PSET 1-2
Arnav Guneta
Period 2
Johns Creek High School
9/5/17 
 */
public class Main {

	public static void main(String[] args) {
		// makes an array of inventories that holds the three types, later passed as a parameter to the warehouse
		Inventory inventories[] = new Inventory[3];

		// makes the widget superheroes array and adds three diff types of widgets to them.
		// partial, empty, and full
		Widget superWidgets[] = new Widget[5];

		Widget superMan = new Widget();
		Widget batMan = new Widget("Batman", "A 3ft tall batman figurine. [MADE IN AMERICA]");
		Widget wonderWoman = new Widget(1.99, 324, 15.55, 19.99, "Wonder Woman",
				"A 2ft tall wonder woman figurine. [MADE IN CHINA]");
		Widget ironMan = new Widget(2.45, 689, 12.99, 16.49, "Ironman",
				"An ironman figurine, made out of plastic. [MADE IN INDONESIA]");
		Widget captainAmerica = new Widget(.99, 199, 9.99, 14.99, "Captain America",
				"Small Captain America figurine made out of rubber and plastic. [MADE IN INDIA]");

		superWidgets[0] = superMan;
		superWidgets[1] = batMan;
		superWidgets[2] = wonderWoman;
		superWidgets[3] = ironMan;
		superWidgets[4] = captainAmerica;

		// makes the widget nfl quarterbacks array and adds three diff types of widgets to them.
		// partial, empty, and full
		Widget nflWidgets[] = new Widget[3];

		Widget mattbarkley = new Widget();
		Widget mathewstafford = new Widget("Mathew Stafford",
				"A bobble-head doll for Mathew Stafford, Detroit Lines Quarterback.");
		Widget aaronrodgers = new Widget(2.98, 1068, 12.23, 14.99, "Aaron Rodgers",
				"A bobble-head doll for Aaron Rodgers, Green Bay Packers Quarterback.");

		nflWidgets[0] = mattbarkley;
		nflWidgets[1] = mathewstafford;
		nflWidgets[2] = aaronrodgers;

		// makes the widget wands array and adds three diff types of widgets to them.
		// partial, empty, and full
		Widget wands[] = new Widget[3];

		Widget harryswand = new Widget();
		Widget hermioneswand = new Widget("Hermione's Wand",
				"Her wand was 10¾ long, made of vine wood, and possessed a dragon heartstring core.");
		Widget ronswand = new Widget(1.99, 7823, 15.55, 19.99, "Ron's Wand", "His wand has a unicorn hair core.");

		wands[0] = harryswand;
		wands[1] = hermioneswand;
		wands[2] = ronswand;


		// creates inventory with the appropriate widget arrays and adds them to the inventory array
		Inventory superhero = new Inventory(superWidgets, "Super Heroes", "An inventory of superhero figurines.");
		inventories[0] = superhero;

		Inventory nfl = new Inventory(nflWidgets, "NFL Quarterback Bobble-Head Dolls",
				"An inventory for NFL Quarterback Bobble-Head Dolls.");
		inventories[1] = nfl;

		Inventory wandInventory = new Inventory(wands, "Harry Potter Action Wands",
				"An inventory for Harry Potter Action Wands of various styles and colors.");
		inventories[2] = wandInventory;

		// creates a warehouse with the appropriate title and address including the array of inventories
		Warehouse warehouse = new Warehouse("Main Warehouse", "3430 Waters Mill Dr.", "Alpharetta", "Georgia", 30022,
				inventories);

		// printing out three different types of warehouse reports
		warehouse.printReportAlpha();
		warehouse.printReportBeta();
		warehouse.printReportCharlie();

	}
}
