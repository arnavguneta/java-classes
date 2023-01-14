package cpsc2150.connectX;

public class GameBoard {

	public static final int MAX_ROW = 6, MAX_COLUMN = 7;
	private char[][] board;

	/**
	 * @pre none
	 * @post initialized array
	 */
	public GameBoard() {
		board = new char[MAX_ROW][MAX_COLUMN];
		// fills array with ' ' values
		for (int i = 0; i < MAX_ROW; i++) {
			for (int j = 0; j < MAX_COLUMN; j++) {
				board[i][j] = ' ';
			}
		}
	}

	/**
	 * @param c the column being checked
	 * @return true if column c is not full, vice versa
	 * @pre 0 <= c < MAX_COLUMN
	 * @post checkIfFree == true iff [c is not full]
	 */
	public boolean checkIfFree(int c) {
		if (board[MAX_ROW - 1][c] == ' ') {
			return true;
		}
		return false;
	}

	/**
	 * @param c column in which the last token was placed
	 * @return true if the last token places results in a 4
	 * in a row horizontally, diagonally, or vertically.
	 * If it doesn't, returns false
	 * @pre 0 <= c < MAX_COLUMN
	 * @post checkForWin == true iff [there are 4 char p in a row horizontally, diagonally, or vertically]
	 */
	public boolean checkForWin(int c) {
		char p = ' ';
		int r = 0;

		// gets the last token placed, and its row index
		for (int i = MAX_ROW - 1; i >= 0; i--) {
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

	/**
	 * @param p the player's marker (X/O)
	 * @param c the column where the token will be placed
	 * @pre checkIfFree(c) == true && 0 <= c < MAX_COLUMN
	 * @post p will be placed in the lowest free spot in column c
	 */
	public void placeToken(char p, int c) {
		// finds the lowest available row and places p there
		for (int i = 0; i < MAX_ROW; i++) {
			if (board[i][c] == ' ') {
				board[i][c] = p;
				return;
			}
		}
	}

	/**
	 * @param r row in which the last token was placed
	 * @param c column in which the last token was placed
	 * @param p the player's marker (X/O)
	 * @return true if there are 4 connected char p in a row horizontally, if not then return false
	 * @pre 0 <= c < MAX_COLUMN && 0 <= r < MAX_ROW
	 * @post checkHorizWin == true iff [there are 4 char p in a row horizontally]
	 */
	public boolean checkHorizWin(int r, int c, char p) {
		int count = 0;
		// go through the row of the last placed marker,
		// and check for four connected markers of the same type horizontally
		for (int i = 0; i < MAX_COLUMN; i++) {
			if (board[r][i] == p)
				count++;
			else
				count = 0;

			if (count >= 4)
				return true;
		}
		return false;
	}

	/**
	 * @param r row in which the last token was placed
	 * @param c column in which the last token was placed
	 * @param p the player's marker (X/O)
	 * @return true if there are 4 connected char p in a row vertically, if not then return false
	 * @pre 0 <= c < MAX_COLUMN && 0 <= r < MAX_ROW
	 * @post checkVertWin == true iff [there are 4 char p in a row vertically]
	 */
	public boolean checkVertWin(int r, int c, char p) {
		int count = 0;
		// go through the column of the last placed marker,
		// and check for four connected markers of the same type vertically
		for (int i = 0; i < MAX_ROW; i++) {
			if (board[i][c] == p)
				count++;
			else
				count = 0;

			if (count >= 4)
				return true;
		}
		return false;
	}

	/**
	 * @param r row in which the last token was placed
	 * @param c column in which the last token was placed
	 * @param p the player's marker (X/O)
	 * @return true if there are 4 connected char p in a row diagonally, if not then return false
	 * @pre 0 <= c < MAX_COLUMN && 0 <= r < MAX_ROW
	 * @post checkDiagWin == true iff [there are 4 char p in a row diagonally]
	 */
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
		for (int diagRows = 0; diagRows < MAX_COLUMN - 4; diagRows++) {
			count = 0;
			// goes down the diagonal (top left to bottom right) and checks if the value at index row, col matches p
			for (row = diagRows, col = 0; row < MAX_ROW && col < MAX_COLUMN; row++, col++) {
				if (board[row][col] == p) {
					count++;
					if (count >= 4)
						return true;
				} else {
					count = 0;
				}
			}

			// goes down the diagonal (top right to bottom left) and checks if the value at index row, col matches p
			for (row = diagRows, col = MAX_COLUMN - 1; row < MAX_ROW && col >= 0; row++, col--) {
				if (board[row][col] == p) {
					count++;
					if (count >= 4)
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
		for (int diagCols = 1; diagCols < MAX_COLUMN - 4; diagCols++) {
			count = 0;
			// goes down the diagonal (top right to bottom left) and checks if the value at index row, col matches p
			for (row = 0, col = diagCols; row < MAX_ROW && col < MAX_COLUMN; row++, col++) {
				if (board[row][col] == p) {
					count++;
					if (count >= 4)
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
		for (int diagCols = MAX_COLUMN - 2; diagCols >= MAX_COLUMN - 4; diagCols--) {
			count = 0;
			// goes down the diagonal (top right to bottom left) and checks if the value at index row, col matches p
			for (row = 0, col = diagCols; row < MAX_ROW && col >= 0; row++, col--) {
				if (board[row][col] == p) {
					count++;
					if (count >= 4)
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
	 * @pre 0 <= c < MAX_COLUMN && 0 <= r < MAX_ROW
	 * @post char at index r,c on the board
	 */
	public char whatsAtPos(int r, int c) {
		return board[r][c];
	}

	/**
	 * @return an output string containing the GameBoard in a string format
	 * @pre board is initialized correctly
	 * @post board in string format
	 */
	@Override public String toString() {
		String out = "|0|1|2|3|4|5|6|\n|";

		// print board, rows flipped and columns are normal
		for (int i = MAX_ROW - 1; i >= 0; i--) {
			for (int j = 0; j < MAX_COLUMN; j++) {
				out += board[i][j] + "|";
			}
			if (!(i == 0))
				out += "\n|";
		}
		out += "\n";
		return out;
	}

	/**
	 * @return true if the game board results in a tie game,
	 * meaning there are no more spaces left.
	 * @pre no previous play has resulted in a win
	 * @post checkTie == true iff [there are no available spaces left on the board]
	 */
	public boolean checkTie() {
		for (int i = 0; i < MAX_COLUMN; i++) {
			if (checkIfFree(i))
				return false;
		}
		return true;
	}

}
