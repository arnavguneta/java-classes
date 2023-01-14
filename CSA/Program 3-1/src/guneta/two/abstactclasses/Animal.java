package guneta.two.abstactclasses;

/*
APCS-A PSET 3-1
Arnav Guneta
Period 2
Johns Creek High School
10/24/17 
 */
public abstract class Animal {

	// 4 field variables
	private String name;
	private String species;
	private int age;
	private int legs;

	// empty constructor
	public Animal() {
		this("No name", "No species", 0, 0);
	}

	// full constructor
	public Animal(String name, String species, int age, int legs) {
		this.name = name;
		this.species = species;
		this.age = age;
		this.legs = legs;
	}

	// 6 abstract methods (implemented in extended classes)
	abstract void walk();

	abstract void sit();

	abstract void run();

	abstract void eat();

	abstract void sleep();

	abstract void makeNoise();

	// getters and setters for private field variables
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}
}
