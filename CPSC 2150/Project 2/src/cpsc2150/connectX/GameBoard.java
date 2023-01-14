package cpsc2150.connectX;

/**
 * @invariant 3 <= rows <= MAX_ROW
 * @invariant 3 <= cols <= MAX_COL
 * @invariant 3 <= inARow <= MAX_IN_A_ROW
 *
 * Correspondence number_of_rows = rows
 * Correspondence number_of_cols = cols
 * Correspondence number_in_a_row = inARow
 * Correspondence this = board[0...rows - 1][0...cols - 1]
 */
public class GameBoard implements IGameBoard {

	private char[][] board;
	private int rows, cols, inARow;

	/**
	 * @param rows   on the board
	 * @param cols   on the board
	 * @param inARow
	 * @pre 3 <= rows <= MAX_ROW, 3 <= cols <= MAX_COLUMN, 3 <= inARow <= 25
	 * @post initialized board[0...rows - 1][0...cols - 1], #rows = rows, #cols = cols, #inARow = inARow
	 */
	public GameBoard(int rows, int cols, int inARow) {
		board = new char[rows][cols];
		// fills array with ' ' values
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = ' ';
			}
		}
		this.rows = rows;
		this.cols = cols;
		this.inARow = inARow;
	}

	public boolean checkIfFree(int c) {
		if (board[rows - 1][c] == ' ') {
			return true;
		}
		return false;
	}

	public boolean checkForWin(int c) {
		char p = ' ';
		int r = 0;

		// gets the last token placed, and its row index
		for (int i = rows - 1; i >= 0; i--) {
			if (board[i][c] != ' ') {
				p = board[i][c];
				r = i;
				break;
			}
		}

		// if last token placed results in either a
		// horiz, diag, or vert 4 in a row, return true
		if (checkHorizWin(r, c, p) || checkVertWin(r, c, p) || checkDiagWin(r, c, p))
			return true;

		return false;
	}

	public void placeToken(char p, int c) {
		// finds the lowest available row and places p there
		for (int i = 0; i < rows; i++) {
			if (board[i][c] == ' ') {
				board[i][c] = p;
				return;
			}
		}
	}

	public boolean checkHorizWin(int r, int c, char p) {
		int count = 0;
		// go through the row of the last placed marker,
		// and check for four connected markers of the same type horizontally
		for (int i = 0; i < cols; i++) {
			if (board[r][i] == p)
				count++;
			else
				count = 0;

			if (count >= inARow)
				return true;
		}
		return false;
	}

	public boolean checkVertWin(int r, int c, char p) {
		int count = 0;
		// go through the column of the last placed marker,
		// and check for four connected markers of the same type vertically
		for (int i = 0; i < rows; i++) {
			if (board[i][c] == p)
				count++;
			else
				count = 0;

			if (count >= inARow)
				return true;
		}
		return false;
	}

	public boolean checkDiagWin(int r, int c, char p) {
		int count = 0, row, col;

		/*
		[\] indicates the positions this checks, [X] indicates overlap of diagonals
		IN ARRAY
		|0|1|2|3|4|5|6|
		|\| | | | | |/|
		|\|\| | | |/|/|
		|\|\|\| |/|/|/|
		| |\|\|X|/|/| |
		| | |X|X|X| | |
		| |/|/|X|\|\| |
		 */
		for (int diagRows = 0; diagRows < cols - 4; diagRows++) {
			count = 0;
			// goes down the diagonal (top left to bottom right) and checks if the value at index row, col matches p
			for (row = diagRows, col = 0; row < rows && col < cols; row++, col++) {
				if (board[row][col] == p) {
					count++;
					if (count >= inARow)
						return true;
				} else {
					count = 0;
				}
			}

			// goes down the diagonal (top right to bottom left) and checks if the value at index row, col matches p
			for (row = diagRows, col = cols - 1; row < rows && col >= 0; row++, col--) {
				if (board[row][col] == p) {
					count++;
					if (count >= inARow)
						return true;
				} else {
					count = 0;
				}
			}
		}

		/*
		[\] indicates the positions this checks
		IN ARRAY
		|0|1|2|3|4|5|6|
		| |\|\|\| | | |
		| | |\|\|\| | |
		| | | |\|\|\| |
		| | | | |\|\|\|
		| | | | | |\|\|
		| | | | | | |\|
		 */
		for (int diagCols = 1; diagCols < cols - 4; diagCols++) {
			count = 0;
			// goes down the diagonal (top right to bottom left) and checks if the value at index row, col matches p
			for (row = 0, col = diagCols; row < rows && col < cols; row++, col++) {
				if (board[row][col] == p) {
					count++;
					if (count >= inARow)
						return true;
				} else {
					count = 0;
				}
			}
		}

		/*
		[\] indicates the positions this checks
		IN ARRAY
		|0|1|2|3|4|5|6|
		| | | |/|/|/| |
		| | |/|/|/| | |
		| |/|/|/| | | |
		|/|/|/| | | | |
		|/|/| | | | | |
		|/| | | | | | |
		 */
		for (int diagCols = cols - 2; diagCols >= cols - 4; diagCols--) {
			count = 0;
			// goes down the diagonal (top right to bottom left) and checks if the value at index row, col matches p
			for (row = 0, col = diagCols; row < rows && col >= 0; row++, col--) {
				if (board[row][col] == p) {
					count++;
					if (count >= inARow)
						return true;
				} else {
					count = 0;
				}
			}
		}
		return false;
	}

	public char whatsAtPos(int r, int c) {
		return board[r][c];
	}

	/**
	 * @return an output string containing the GameBoard in a string format
	 * @pre board is initialized correctly
	 * @post board in string format
	 */
	@Override public String toString() {
		String out = "| ";

		for (int i = 0; i < cols; i++) {
			// no space after 9 because it enters double digits
			if (i < 9)
				out += i + "| ";
			else
				out += i + "|";
		}

		out += "\n|";

		// print board, rows flipped and columns are normal
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j < cols; j++) {
				out += board[i][j] + " |";
			}
			if (!(i == 0))
				out += "\n|";
		}
		out += "\n";
		return out;
	}

	public int getNumRows() {
		return rows;
	}

	public int getNumColumns() {
		return cols;
	}

	public int getNumToWin() {
		return inARow;
	}
}
