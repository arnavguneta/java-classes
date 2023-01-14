/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
10/19/17 
 */
public abstract class Pet {

	String name;
	int age;
	int numLegs;
	boolean ugly;

	public Pet() {
		this("", 0, 0, false);
	}

	public Pet(String name, int age, int numLegs, boolean ugly) {
		this.name = name;
		this.age = age;
		this.numLegs = numLegs;
		this.ugly = ugly;
	}

	abstract void sleep();

	abstract void play();

	abstract void eat();

}
