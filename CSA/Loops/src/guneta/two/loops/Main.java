package guneta.two.loops;

/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
8/23/17 
 */
public class Main {

	public static void main(String[] args) {

		int x = 0;

		while (x < 10) {
			System.out.println("Looping. " + x);
			x++;
		}

		int y = 12;

		do {
			System.out.println("Looping.. " + y);
			y--;

		} while (y > 0);

		for (int i = 0; i < 10; i++) {
			System.out.println("Looping... " + i);
		}
	}

}
