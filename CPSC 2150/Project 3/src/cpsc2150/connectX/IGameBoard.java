package cpsc2150.connectX;

/**
 * A game board represents a 2 dimensional grid of characters. It is a game board for a connectX game.
 * Indexing starts at [0][0], the board is printed flipped around the X axis.
 *
 * Defines: number_of_cols: Z
 * 			number_of_rows: Z
 * 			number_in_a_row: Z
 * Constraints: 3 <= number_of_cols <= MAX_COLUMN
 * 				3 <= number_of_rows <= MAX_ROW
 * 				3 <= number_in_a_row <= MAX_IN_A_ROW
 * Initialization ensures:
 * 		Board contains only blank characters and the size of the board is
 * 		number_of_cols X number_of_rows
 */
public interface IGameBoard {
	public static final int MAX_ROW = 100, MAX_COLUMN = 100, MAX_IN_A_ROW = 25;

	/**
	 * @param c the column being checked
	 * @return true if column c is not full, vice versa
	 * @pre 0 <= c < number_of_cols
	 * @post checkIfFree == true iff [c is not full]
	 */
	default public boolean checkIfFree(int c) {
		if (whatsAtPos(getNumRows() - 1, c) == ' ') {
			return true;
		}
		return false;
	}
	/**
	 * @param c column in which the last token was placed
	 * @return true if the last token places results in a 4
	 * in a row horizontally, diagonally, or vertically.
	 * If it doesn't, returns false
	 * @pre 0 <= c < number_of_cols
	 * @post checkForWin == true iff [there are 4 char p in a row horizontally, diagonally, or vertically]
	 */
	default public boolean checkForWin(int c) {
		char p = ' ';
		int r = 0;

		// gets the last token placed, and its row index
		for (int i = getNumRows() - 1; i >= 0; i--) {
			if (whatsAtPos(i, c) != ' ') {
				p = whatsAtPos(i, c);
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

	/**
	 * @param p the player's marker (X/O)
	 * @param c the column where the token will be placed
	 * @pre checkIfFree(c) == true && 0 <= c < number_of_cols
	 * @post p will be placed in the lowest free spot in column c
	 */
	public void placeToken(char p, int c);

	/**
	 * @param r row in which the last token was placed
	 * @param c column in which the last token was placed
	 * @param p the player's marker (X/O)
	 * @return true if there are number_in_a_row connected char p in a row horizontally, if not then return false
	 * @pre 0 <= c < number_of_cols && 0 <= r < number_of_rows
	 * @post checkHorizWin == true iff [there are number_in_a_row char p in a row horizontally]
	 */
	default public boolean checkHorizWin(int r, int c, char p) {
		int count = 0;
		// go through the row of the last placed marker,
		// and check for four connected markers of the same type horizontally
		for (int i = 0; i < getNumColumns(); i++) {
			if (whatsAtPos(r, i) == p)
				count++;
			else
				count = 0;

			if (count >= getNumToWin())
				return true;
		}
		return false;
	}

	/**
	 * @param r row in which the last token was placed
	 * @param c column in which the last token was placed
	 * @param p the player's marker (X/O)
	 * @return true if there are number_in_a_row connected char p in a row vertically, if not then return false
	 * @pre 0 <= c < number_of_cols && 0 <= r < number_of_rows
	 * @post checkVertWin == true iff [there are number_in_a_row char p in a row vertically]
	 */
	default public boolean checkVertWin(int r, int c, char p) {
		int count = 0;
		// go through the column of the last placed marker,
		// and check for four connected markers of the same type vertically
		for (int i = 0; i < getNumRows(); i++) {
			if (whatsAtPos(i, c) == p)
				count++;
			else
				count = 0;

			if (count >= getNumToWin())
				return true;
		}
		return false;
	}

	/**
	 * @param r row in which the last token was placed
	 * @param c column in which the last token was placed
	 * @param p the player's marker (X/O)
	 * @return true if there are number_in_a_row connected char p in a row diagonally, if not then return false
	 * @pre 0 <= c < number_of_cols && 0 <= r < number_of_rows
	 * @post checkDiagWin == true iff [there are number_in_a_row char p in a row diagonally]
	 */
	default public boolean checkDiagWin(int r, int c, char p) {
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
		for (int diagRows = 0; diagRows < getNumColumns() - 4; diagRows++) {
			count = 0;
			// goes down the diagonal (top left to bottom right) and checks if the value at index row, col matches p
			for (row = diagRows, col = 0; row < getNumRows() && col < getNumColumns(); row++, col++) {
				if (whatsAtPos(row, col) == p) {
					count++;
					if (count >= getNumToWin())
						return true;
				} else {
					count = 0;
				}
			}

			// goes down the diagonal (top right to bottom left) and checks if the value at index row, col matches p
			for (row = diagRows, col = getNumColumns() - 1; row < getNumRows() && col >= 0; row++, col--) {
				if (whatsAtPos(row, col) == p) {
					count++;
					if (count >= getNumToWin())
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
		for (int diagCols = 1; diagCols < getNumColumns() - 4; diagCols++) {
			count = 0;
			// goes down the diagonal (top right to bottom left) and checks if the value at index row, col matches p
			for (row = 0, col = diagCols; row < getNumRows() && col < getNumColumns(); row++, col++) {
				if (whatsAtPos(row, col) == p) {
					count++;
					if (count >= getNumToWin())
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
		for (int diagCols = getNumColumns() - 2; diagCols >= getNumColumns() - 4; diagCols--) {
			count = 0;
			// goes down the diagonal (top right to bottom left) and checks if the value at index row, col matches p
			for (row = 0, col = diagCols; row < getNumRows() && col >= 0; row++, col--) {
				if (whatsAtPos(row, col) == p) {
					count++;
					if (count >= getNumToWin())
						return true;
				} else {
					count = 0;
				}
			}
		}
		return false;
	}

	/**
	 * @param r row index
	 * @param c column index
	 * @return character at the index of row r and column c on the board
	 * @pre 0 <= c < number_of_cols && 0 <= r < number_of_rows
	 * @post char at index r,c on the board
	 */
	public char whatsAtPos(int r, int c);

	/**
	 * @return true if the game board results in a tie game,
	 * meaning there are no more spaces left.
	 * @pre no previous play has resulted in a win
	 * @post checkTie == true iff [there are no available spaces left on the board]
	 */
	default public boolean checkTie() {
		for (int i = 0; i < getNumColumns(); i++) {
			if (checkIfFree(i))
				return false;
		}
		return true;
	}

	/**
	 * @pre none
	 * @post num_of_rows
	 * @return number of rows in the game board
	 */
	public int getNumRows();

	/**
	 * @pre none
	 * @post num_of_cols
	 * @return number of cols in the game board
	 */
	public int getNumColumns();

	/**
	 * @pre none
	 * @post num_in_a_row
	 * @return number of markers in a row needed to win
	 */
	public int getNumToWin();

}
