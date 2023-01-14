package guneta.two.interfaces;

/*
APCS-A PSET 3-1
Arnav Guneta
Period 2
Johns Creek High School
10/22/17 
 */
public class Main {

	public static void main(String args[]) {
		// instantiates the car and boat objects
		Car camry = new Car("Camry", "Toyota", false, false, true, true, 0);
		Boat jet = new Boat("Jet", "Northwest Boats", false, false, true, true, true);
		// car methods
		String car =
				"[" + camry.getName().toUpperCase() + "] Name: " + camry.getName() + "\n" + camry.getCompany() + "\n"
						+ camry.stop() + "\n" + camry.run() + "\n" + camry.start() + "\n" + camry.idle() + "\n" + camry
						.run() + "\n" + camry.speeds() + "\n" + camry.run() + "\n" + camry.speeds() + "\n" + camry
						.stop() + "\n";
		// boat methods
		String boat =
				"[" + jet.getName().toUpperCase() + "] Name: " + jet.getName() + "\n" + jet.getCompany() + "\n" + jet
						.stop() + "\n" + jet.docks() + "\n" + jet.run() + "\n" + jet.start() + "\n" + jet.idle() + "\n"
						+ jet.run() + "\n" + jet.launches() + "\n" + jet.run() + "\n" + jet.stop() + "\n" + jet.docks()
						+ "\n" + jet.launches() + "\n";
		// prints both using one print statment
		System.out.println(car + "\n\n" + boat);
	}

}
