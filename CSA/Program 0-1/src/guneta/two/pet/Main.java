package guneta.two.pet;

/*
APCSA PSET 0-1
Arnav Guneta
Period 2
Johns Creek High School
8/10/2017
 */
public class Main {

	public static void main(String[] args) {

		// instantiates pet objects
		Pet pet1 = new Pet();
		Pet pet2 = new Pet("Dog", "Big");
		Pet pet3 = new Pet("Cat", "Small", 9, 39.89f);

		// loops through pet lists and prints them all
		for (Pet pets : Pet.pets) {
			pets.printPet();
		}
	}

}
