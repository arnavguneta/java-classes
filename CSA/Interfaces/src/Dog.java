/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
10/13/17 
 */
public class Dog implements TotalNoises {

	private String name;

	public Dog (String name) {
		this.name = name;
	}

	@Override public void makeNoise(int repeat) {
		for (int i = 0; i < repeat; i++) {
			System.out.println("Bark ");
		}
	}

	@Override public void makeSadNoise(String sound) {
		System.out.println("I'm sad, " + sound);
	}

	@Override public void talk() {
		System.out.println("Ruff, ruff.");
	}

	@Override public void PainSound() {

	}
}
