/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
10/13/17 
 */
public class Main {

	public static void main (String args[]) {

		Dog dog = new Dog("Rover");
		Cat meanCat = new Cat("Fifi");

		dog.talk();
		dog.makeNoise(3);
		dog.makeSadNoise("Whine");

		System.out.println("\n\n");
		meanCat.talk();
		meanCat.makeNoise(6);
		meanCat.makeSadNoise("Hiss");

	}
}
