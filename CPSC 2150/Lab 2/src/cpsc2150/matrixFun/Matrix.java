package cpsc2150.matrixFun;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Matrix {

	private int [][] matrix;

	/**
	 * A constructor for the Matrix class
	 * @pre
	 * rows <= 9 and >=0
	 * columns <= 9 and >=0
	 * values list has the right amount of values
	 * @post
	 * initialized matrix with proper size and values
	 * @param rows rows of the Matrix
	 * @param columns columns of the Matrix
	 * @param values a list of values (ordered w/ first row and first column)
	 */
	public Matrix(int rows, int columns, List<Integer> values) {
		matrix = new int[rows][columns];
		// when called by transpose
		if (values == null)
			return;
		Iterator itr = values.iterator();
		for (int row = 0; row < getRows(); row++) {
			for (int column = 0; column < getColumns(); column++) {
				matrix[row][column] = (int) itr.next();
			}
		}
	}

	/**
	 * @pre
	 * matrix is initialized with rows and cols (<=9 and >=0)
	 * @post
	 * number of rows in the matrix
	 * @return the number of rows of the matrix
	 */
	public int getRows() {
		return matrix.length;
	}
	/**
	 * @pre
	 * matrix is initialized with rows and cols (<=9 and >=0)
	 * @post
	 * number of columns in the matrix
	 * @return the number of columns of the matrix
	 */
	public int getColumns() {
		return matrix[0].length;
	}

	/**
	 * @pre
	 * matrix exists
	 * @post
	 * the matrix
	 * @return matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * Adds two matrices
	 * @pre
	 * addMatrix and this matrix have equivalent rows and columns
	 * @post
	 * a matrix that contains the sum of this and addMatrix
	 * @param addMatrix matrix being added
	 * @return the sum of the two matrices
	 */
	public Matrix add(Matrix addMatrix) {
		List<Integer> values = new ArrayList<>();
		// populates list with the sum of both matrices
		for (int row = 0; row < getRows(); row++) {
			for (int column = 0; column < getColumns(); column++) {
				values.add(this.getMatrix()[row][column] + addMatrix.getMatrix()[row][column]);
			}
		}
		return new Matrix(this.getRows(), this.getColumns(), values);
	}

	/**
	 * subtracts two matrices
	 * @pre
	 * subMatrix and this matrix have equivalent rows and columns
	 * @post
	 * a matrix that contains the difference of this matrix and subMatrix
	 * @param subMatrix matrix being added
	 * @return the subtraction of the two matrices
	 */
	public Matrix subtract(Matrix subMatrix) {
		List<Integer> values = new ArrayList<>();
		// populates list with the difference of both matrices
		for (int row = 0; row < getRows(); row++) {
			for (int column = 0; column < getColumns(); column++) {
				values.add(this.getMatrix()[row][column] - subMatrix.getMatrix()[row][column]);
			}
		}
		return new Matrix(this.getRows(), this.getColumns(), values);
	}

	/**
	 * @pre
	 * matrix values are initialized correctly
	 * @post
	 * the transpose of this matrix
	 * @return transposed matrix
	 */
	public Matrix transpose() {
		Matrix transposedMatrix = new Matrix(this.getColumns(), this.getRows(), null);
		// swaps rows with columns
		for (int row = 0; row < getRows(); row++) {
			for (int column = 0; column < getColumns(); column++) {
				transposedMatrix.getMatrix()[column][row] = this.getMatrix()[row][column];
			}
		}
		return transposedMatrix;
	}

	/**
	 * @pre
	 * properly initialized matrix
	 * @post
	 * formatted output string
	 * @return formatted output of the matrix
	 */
	@Override
	public String toString() {
		String out = "";
		for (int row = 0; row < getRows(); row++) {
			for (int column = 0; column < getColumns(); column++) {
				out += "| " + this.getMatrix()[row][column] + " ";
			}
			out += "|\n";
		}
		return out;
	}

}