/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
10/30/17 
 */
public class Merge {

	public static void main (String args[]) {

		int array[] = {12, 4, 1, 44, 77, 62, 43};

		for (int i : array) {
			System.out.print(i + "\t");
		}
		
		merge(array);

		for (int i : array) {
			System.out.print(i + "\t");
		}

	}
	
	public static int[] merge (int[] list) {
		if (list.length < 2) {
			return list;
		}
		
		int[] left = new int[list.length/2];
		int[] right = new int[list.length - left.length];
		
		System.arraycopy(list, 0, left, 0, left.length);
		System.arraycopy(list, left.length, right, 0, right.length);
		
		merge(left);
		merge(right);
		
		combine(left, right, list);
		
		return list;
	}

	private static void combine(int[] left, int[] right, int[] result) {

		int indexLeft = 0, indexRight = 0, indexResult = 0;

		while ((indexLeft < left.length) && (indexRight < right.length)) {

			if (left[indexLeft] < right[indexRight]) {
				result[indexResult] = left[indexLeft];
				indexLeft++;
			} else {
				result[indexResult] = right[indexRight];
				indexRight++;
			}
			indexResult++;


		}

		System.arraycopy(left, indexLeft, result, indexResult, left.length);
		System.arraycopy(right, indexRight, result, indexResult, right.length - indexRight);

	}

}
