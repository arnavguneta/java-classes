package guneta.two.abstactclasses;

/*
APCS-A PSET 3-1
Arnav Guneta
Period 2
Johns Creek High School
10/24/17 
 */
public class Dog extends Animal {

	// empty constructor
	public Dog() {
		super();
	}

	// full constructor
	public Dog(String name, String species, int age, int legs) {
		super(name, species, age, legs);
	}

	// abstract methods implemented from Animal, all use field variables
	@Override void walk() {
		System.out.println(getName() + " is walking with its " + getLegs() + " legs." );
	}

	@Override void sit() {
		System.out.println(getName() + " is sitting still.");
	}

	@Override void run() {
		System.out.println(getName() + " is running with its " + getLegs() + " legs." );
	}

	@Override void eat() {
		System.out.println(getName() + " is eating.");
	}

	@Override void sleep() {
		System.out.println(getName() + " is sleeping.");
	}

	@Override void makeNoise() {
		System.out.println(getName() + " is barking.");
	}
}
