package cpsc2150.connectX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @invariant 3 <= rows <= MAX_ROW
 * @invariant 3 <= cols <= MAX_COL
 * @invariant 3 <= inARow <= MAX_IN_A_ROW
 *
 * Correspondence number_of_rows = rows
 * Correspondence number_of_cols = cols
 * Correspondence number_in_a_row = inARow
 */
public class GameBoardMem extends AbsGameBoard implements IGameBoard{

	private Map<Integer, List<Character>> board;
	private int rows, cols, inARow;

	/**
	 * @param rows   on the board
	 * @param cols   on the board
	 * @param inARow
	 * @pre 3 <= rows <= MAX_ROW, 3 <= cols <= MAX_COLUMN, 3 <= inARow <= 25
	 * @post initialized board, #rows = rows, #cols = cols, #inARow = inARow
	 */
	public GameBoardMem(int rows, int cols, int inARow) {
		board = new HashMap<>();

		this.rows = rows;
		this.cols = cols;
		this.inARow = inARow;
	}

	public void placeToken(char p, int c) {
		// if the column already has a character in it
		if (board.containsKey(c)) {
			// add token p on top of the existing column
			board.get(c).add(p);
		} else {
			// creates a new column and inserts the character into it
			List<Character> tokens = new ArrayList<>();
			tokens.add(p);
			board.put(c, tokens);
		}
	}

	public char whatsAtPos(int r, int c) {
		// if the column exists
		if (board.containsKey(c)) {
			// and the specified row has a value
			if (board.get(c).size() - 1 >= r) {
				return board.get(c).get(r);
			} else {
				return ' ';
			}
		} else {
			return ' ';
		}
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
