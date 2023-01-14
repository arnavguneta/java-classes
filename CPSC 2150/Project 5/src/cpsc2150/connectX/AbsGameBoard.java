package cpsc2150.connectX;

public abstract class AbsGameBoard implements IGameBoard {
	/**
	 * @return an output string containing the GameBoard in a string format
	 * @pre board is initialized correctly
	 * @post board in string format
	 */
	@Override public String toString() {
		String out = "| ";

		for (int i = 0; i < this.getNumColumns(); i++) {
			// no space after 9 because it enters double digits
			if (i < 9)
				out += i + "| ";
			else
				out += i + "|";
		}

		out += "\n|";

		// print board, rows flipped and columns are normal
		for (int i = this.getNumRows() - 1; i >= 0; i--) {
			for (int j = 0; j < this.getNumColumns(); j++) {
				out += this.whatsAtPos(i,j) + " |";
			}
			if (!(i == 0))
				out += "\n|";
		}
		out += "\n";
		return out;
	}
}
