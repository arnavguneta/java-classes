/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
10/13/17 
 */
public abstract class Cat implements VocalExpression, LitterBox {

	private String name;

	public Cat(String name) {
		this.name = name;
	}

	@Override public void makeNoise(int repeat) {
		for (int i = 0; i < repeat; i++) {
			System.out.println("Meow ");
		}
	}

	@Override public void makeSadNoise(String sound) {
		System.out.println("I hate humans, " + sound);
	}

	@Override public void talk() {
		System.out.println("Scratch dog in face, chase squirrel and eat it!");
	}

	@Override public void useLitterBox() {
		System.out.println("o");
		String s = "aa";
		String a = "s";
		s.concat(a);
	}
}
