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
public class GameBoard extends AbsGameBoard implements IGameBoard {

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

	public void placeToken(char p, int c) {
		// finds the lowest available row and places p there
		for (int i = 0; i < rows; i++) {
			if (board[i][c] == ' ') {
				board[i][c] = p;
				return;
			}
		}
	}

	public char whatsAtPos(int r, int c) {
		return board[r][c];
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
