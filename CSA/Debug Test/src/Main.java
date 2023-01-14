/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
9/15/17 
 */
public class Main {

	public static void main(String[] args) {

		int[] myArray = new int[3];
		int x = 4;
		int y = x * 12;

		System.out.println(x);
		System.out.println(y);

		for (int i : myArray) {
			i = y-x;
		}
	}

}
