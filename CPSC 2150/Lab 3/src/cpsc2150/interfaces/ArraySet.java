package cpsc2150.interfaces;

public class ArraySet implements ISet{

	private int[] set;

	/**
	 * @pre
	 * set exists
	 * @post
	 * initialized set
	 */
	public ArraySet() {
		set = new int[ISet.MAX_SIZE];
	}

	@Override public void add(Integer val) {
		// check for duplicates
		if (!contains(val)) {
			set[getSize()] = val;
		} else {
			System.out.println("That value is already in the set.");
		}
	}

	@Override public Integer removePos(int Pos) {
		int value = set[Pos];
		for (int i = Pos; i < getSize(); i++) {
			set[Pos] = set[Pos + 1];
			Pos++;
		}
		return value;
	}

	@Override public boolean contains(Integer val) {
		for (int i : set) {
			if (i == val) return true;
		}
		return false;
	}

	@Override public int getSize() {
		int count = 0;
		for (int i : set) {
			if (i != 0)
				count++;
		}
		return count;
	}

	/**
	 * @pre
	 * set is initialized
	 * @post
	 * string containing all values of the set
	 * @return a string that contains all values of the set separated by commas.
	 */
	@Override public String toString() {
		String out = "";
		System.out.println("Set is: ");
		for (int i = 0; i < getSize(); i++) {
			out += set[i] + ", ";
		}
		return out;
	}
}
