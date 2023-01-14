package guneta.two.abstactclasses;

/*
APCS-A PSET 3-1
Arnav Guneta
Period 2
Johns Creek High School
10/24/17 
 */
public class Main {

	public static void main(String args[]) {
		// intializes the three classes
		Dog dog = new Dog("Bonu", "Maltese", 6, 4);
		Dinosaur dino = new Dinosaur("T-Dog", "Tyrannosaurus Rex", 20, 2);
		Lizard liz = new Lizard("Spock", "Basilisk", 3, 4);

		// print the report, dog dino and liz are passed in as their super type
		printReport("dog", dog);
		printReport("dinosaur", dino);
		printReport("lizard", liz);

	}

	// prints out all field variables for the three classes and calls methods inside status block
	public static void printReport(String type, Animal animal) {
		System.out.println(
				"************ " + type.toUpperCase() + " ************\n\n" + "----------------------------------\n\n"
						+ "Name: " + animal.getName() + "\nSpecies: " + animal.getSpecies() + "\nAge: " + animal
						.getAge() + "\nLegs: " + animal.getLegs() + "\n\n" + "----------------------------------\n\n");
		System.out.println("************* STATUS *************\n\n");

		animal.sit();
		animal.eat();
		animal.sleep();
		animal.walk();
		animal.run();
		animal.makeNoise();

		System.out.println("\n\n**********************************\n\n");
	}

}
