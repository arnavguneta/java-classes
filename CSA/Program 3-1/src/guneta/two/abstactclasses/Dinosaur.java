package guneta.two.abstactclasses;

/*
APCS-A PSET 3-1
Arnav Guneta
Period 2
Johns Creek High School
10/24/17 
 */
public class Dinosaur extends Animal{

	// empty constructor
	public Dinosaur() {
		super();
	}

	// full constructor
	public Dinosaur(String name, String species, int age, int legs) {
		super(name, species, age, legs);
	}

	// 6 abstract methods implemented from Animal, use almost all field variables
	@Override void walk() {
		System.out.println(getName() + " is walking with its " + getLegs() + " legs." );
	}

	@Override void sit() {
		System.out.println("The " + getAge() + " year old Dinosaur, " + getName() + ", is sitting still.");
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
		System.out.println(getName() + " roars.");
	}
}
