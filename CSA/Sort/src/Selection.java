/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
10/24/17 
 */
public class Selection {

	public static void main(String args[]) {
		int array[] = {2, 4, 9, 0, 11, 3, 5, 20, 10, 12, 1, 19}; // forgot semicolon

		for (int i = 0; i < array.length - 1; i++) { // forgot to define 'int' and subtract one from length
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) { // forgot to define 'int'
				if (array[j] < array[minIndex]) { // array[i]
					minIndex = j;
				}
			} // forgot the brace

			if (minIndex != i) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp; // use minIndex instead of J
			}

		}

		for (int i : array) {
			System.out.print(i + ", ");
		}

	}

}
