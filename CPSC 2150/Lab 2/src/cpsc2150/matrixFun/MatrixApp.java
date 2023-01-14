package cpsc2150.matrixFun;

/*
Name: Arnav Guneta
Lab: 2
Course: CPSC 2150
Due Date: 2/1/19
Description: Creating a multi-class application and practicing with writing contracts
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixApp {

	final static int MAX = 10, MIN = 1;

	public static void main (String args[]) {

		// choice is the integer selected by the user
		int choice = 0, rows = -1, columns = -1;
		System.out.println("1. Get the Transpose of a Matrix\n" + "2. Add two matrices\n"
				+ "3. Find the difference of two matrices\n" + "4. Quit");
		Scanner scanner = new Scanner(System.in);
		choice = Integer.parseInt(scanner.nextLine());

		switch (choice) {
			case 1:
				// whenever transpose is picked, initialize columns rows and values
				rows = MatrixApp.initRowsCols(scanner, rows, columns, "rows");
				columns = MatrixApp.initRowsCols(scanner, rows, columns, "cols");
				System.out.println("The transpose is:");
				System.out.println(MatrixApp.initData(scanner, rows, columns).transpose().toString());
				break;
			case 2:
				rows = MatrixApp.initRowsCols(scanner, rows, columns, "rows");
				columns = MatrixApp.initRowsCols(scanner, rows, columns, "cols");
				System.out.println("What values should be in the first matrix?");
				// the first matrix
				Matrix m1 = MatrixApp.initData(scanner, rows, columns);
				System.out.println("What values should be in the second matrix?");
				// the second matrix
				Matrix m2 = MatrixApp.initData(scanner, rows, columns);
				System.out.println("The sum of these matrices is:");
				System.out.println(m1.add(m2).toString());
				break;
			case 3:
				rows = MatrixApp.initRowsCols(scanner, rows, columns, "rows");
				columns = MatrixApp.initRowsCols(scanner, rows, columns, "cols");
				System.out.println("What values should be in the first matrix?");
				m1 = MatrixApp.initData(scanner, rows, columns);
				System.out.println("What values should be in the second matrix?");
				m2 = MatrixApp.initData(scanner, rows, columns);
				System.out.println("The first matrix minus the second matrix is:");
				System.out.println(m1.subtract(m2).toString());
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice, exiting program.");

		}
	}

	/**
	 * @pre
	 * option is either rows or cols
	 * @post
	 * the number of rows or columns read in from keyboard input
	 * @param scanner scanner variable used to obtain values
	 * @param rows rows for matrix
	 * @param cols columns for matrix
	 * @param option either rows or columns
	 * @return the number of rows or columns
	 */
	public static int initRowsCols(Scanner scanner, int rows, int cols, String option) {
		if (option.equalsIgnoreCase("rows")) {
			do {
				// prompts user for the # of rows, and repeatedly loops until valid input is read
				System.out.println("How many rows should the matrix have?");
				rows = Integer.parseInt(scanner.nextLine());

				if (rows > MAX || rows < MIN) {
					System.out.println("Number of rows must be between " + MIN + " and " + MAX);
				}

			} while (rows > MAX || rows < MIN);

			return rows;

		} else if (option.equalsIgnoreCase("cols")) {
			do {
				// prompts user for the # of cols, and repeatedly loops until valid input is read
				System.out.println("How many columns should the matrix have?");
				cols = Integer.parseInt(scanner.nextLine());

				if (cols > MAX || cols < MIN) {
					System.out.println("Number of rows must be between " + MIN + " and " + MAX);
				}
			} while (cols > MAX || cols < MIN);

			return cols;

		}
		return -1;
	}

	/**
	 * @pre
	 * rows >= 1 and <= 10
	 * cols >=1 and <= 10
	 * @post
	 * a matrix populated with values provided by the user
	 * @param scanner scanner variable used to read values
	 * @param rows rows for matrix, greater than or equal to 1 and less than or equal to 10
	 * @param cols columns for matrix, greater than or equal to 1 and less than or equal to 10
	 * @return a populated matrix
	 */
	public static Matrix initData(Scanner scanner, int rows, int cols) {
		List<Integer> values =  new ArrayList<>();

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < cols; column++) {
				System.out.println("Enter the value for row "  + (row + 1) + " column " +  (column + 1));
				values.add(Integer.parseInt(scanner.nextLine()));
			}
		}

		return new Matrix(rows, cols, values);
	}

}