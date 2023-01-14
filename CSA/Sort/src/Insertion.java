/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
10/26/17 
 */
public class Insertion {

	public static void main(String args[]) {

		int array[] = { 91, 42, 22, 126, 0, 32 };

		for (int i = 1, n = array.length; i < n; i++) {
			int element = array[i];
			int j = i - 1;
			// 42
			// 91
			while (j >= 0 && array[j] > element) {
				array[i] = array[j];
				j = j - 1;
			}

			array[j + 1] = element;
		}

		for (int i : array) {
			System.out.print(i + ", ");
		}

	}
}
