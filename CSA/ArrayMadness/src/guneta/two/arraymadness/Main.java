package guneta.two.arraymadness;

import java.util.Random;

/*
APCS-A PSET 2-1
Arnav Guneta
Period 2
Johns Creek High School
9/28/17
 */
public class Main {

	public static void main (String args[]) {

		char[][] myArray = new char[10][10];

		// FIRST PROBLEM

		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (r % 2 == 0) {
					if (c % 2 == 0) {
						myArray[r][c] = 'X';
					} else {
						myArray[r][c] = 'O';
					}
					System.out.print(myArray[r][c]);
				} else {
					if (c % 2 == 0) {
						myArray[r][c] = 'O';
					} else {
						myArray[r][c] = 'X';
					}
					System.out.print(myArray[r][c]);

				}
			}
			System.out.println("");
		}

		System.out.println("\n\n");
		// END OF FIRST PROBLEM

		// SECOND PROBEM

		int array[][] = new int[20][20];
		int sumRow[] = new int[20];
		int sum = 0;
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {

				if (r > 0) {
					array[r][c] = ((r*10) * (r + (2 - r))) + (c + 1);
				} else {
					array[r][c] = (c + 1);
				}

				sum += array[r][c];

				System.out.print(array[r][c] + " ");
			}

			sumRow[r] = sum;
			sum = 0;

			System.out.println("\t\t\t\t\t\t\t\t\t" + sumRow[r] );
		}

		System.out.println("");
		
		// END SECOND PROBLEM

		// THIRD PROBLEM

		char anArray[][] = new char[13][2];
		int x = 90;

		for (int r = 0; r < 13; r++) {
			for (int c = 0; c < 2; c++) {
				anArray[r][c] = (char) x;
				x--;
				System.out.print(anArray[r][c] + " ");
				if (c == 1) {
					System.out.println("");
				}
			}
		}

		System.out.println("");

		for (int r = 12; r >= 0; r--) {
			for (int c = 1; c >= 0; c--) {
				if (r == 6 && c == 0) {
					System.out.println("");
				}

				if (r == 0 && c == 0) {
					System.out.println(anArray[r][c]);
				} else {
					System.out.print(anArray[r][c] + ", ");
				}

			}
		}

		System.out.println("");

		// END OF THIRD PROBLEM

		// FOURTH PROBLEM

		char anotherArray[][] = new char[30][30];
		int countArray[] = new int[26];
		Random rand = new Random();

		for (int r = 0; r < 30; r++) {
			for (int c = 0; c < 30; c++) {

				int  n = rand.nextInt(26) + 65;
				anotherArray[r][c] = (char) n;

				countArray[Math.abs(65 - n)] += 1;

				System.out.print(anotherArray[r][c] + "\t");
			}

			System.out.println("");
		}

		System.out.println("");

		for (int i = 65; i < 91; i++) {
			System.out.print((char) i + "\t");
		}

		System.out.println("");

		for (int i : countArray) {
			System.out.print(i + "\t");
		}
	}


}
