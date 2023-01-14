/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
10/19/17 
 */
public class Puppy extends Pet {

	Puppy() {
		super();
	}

	Puppy(String name, int age, int numLegs, boolean ugly) {
		super(name, age, numLegs, ugly);
	}

	@Override void sleep() {
		System.out.println("Sleeping puppy");
	}

	@Override void play() {
		System.out.println("Playing puppy");
	}

	@Override void eat() {
		System.out.println("Eating puppy");
	}
}
