package guneta.two.pet;

/*
APCSA PSET 0-1
Arnav Guneta
Period 2
Johns Creek High School
8/16/17 
 */

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL") public class Pet {
	// list with all pets
	static List<Pet> pets = new ArrayList<>();

	// object fields
	private String petType;
	private String sizeDescription;
	private int petAge;
	private float petCost;

	// empty contructor
	public Pet() {
		this("", "", 0, 0);
	}

	// partial constructor
	public Pet(String petType, String sizeDescription) {
		this(petType, sizeDescription, 0, 0);
	}

	// full constructor
	public Pet(String petType, String sizeDescription, int petAge, float petCost) {
		setPetType(petType);
		setSizeDescription(sizeDescription);
		setPetAge(petAge);
		setPetCost(petCost);
		pets.add(this);
	}

	// getters and setters
	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getSizeDescription() {
		return sizeDescription;
	}

	public void setSizeDescription(String sizeDescription) {
		this.sizeDescription = sizeDescription;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public float getPetCost() {
		return petCost;
	}

	public void setPetCost(float petCost) {
		this.petCost = petCost;
	}

	// prints all pets in the list
	public void printPet() {
		System.out.println(
				"Pet:\n Type: " + getPetType() + "\n Size Description: " + getSizeDescription() + "\n Age: "
						+ getPetAge() + "\n Cost: " + getPetCost() + "\n");
	}
}