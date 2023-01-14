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
	public boolean checkIfFree(int c);

	/**
	 * @param c column in which the last token was placed
	 * @return true if the last token places results in a 4
	 * in a row horizontally, diagonally, or vertically.
	 * If it doesn't, returns false
	 * @pre 0 <= c < number_of_cols
	 * @post checkForWin == true iff [there are 4 char p in a row horizontally, diagonally, or vertically]
	 */
	public boolean checkForWin(int c);

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
	public boolean checkHorizWin(int r, int c, char p);

	/**
	 * @param r row in which the last token was placed
	 * @param c column in which the last token was placed
	 * @param p the player's marker (X/O)
	 * @return true if there are number_in_a_row connected char p in a row vertically, if not then return false
	 * @pre 0 <= c < number_of_cols && 0 <= r < number_of_rows
	 * @post checkVertWin == true iff [there are number_in_a_row char p in a row vertically]
	 */
	public boolean checkVertWin(int r, int c, char p);

	/**
	 * @param r row in which the last token was placed
	 * @param c column in which the last token was placed
	 * @param p the player's marker (X/O)
	 * @return true if there are number_in_a_row connected char p in a row diagonally, if not then return false
	 * @pre 0 <= c < number_of_cols && 0 <= r < number_of_rows
	 * @post checkDiagWin == true iff [there are number_in_a_row char p in a row diagonally]
	 */
	public boolean checkDiagWin(int r, int c, char p);

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
