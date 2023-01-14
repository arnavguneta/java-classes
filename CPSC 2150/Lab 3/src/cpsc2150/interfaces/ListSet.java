package cpsc2150.interfaces;

import java.util.ArrayList;
import java.util.List;

public class ListSet implements ISet{

	private List<Integer> set;

	/**
	 * @pre
	 * set exists
	 * @post
	 * initialized set
	 */
	public ListSet() {
		set = new ArrayList<>(ISet.MAX_SIZE);
	}

	@Override public void add(Integer val) {
		// check for duplicates
		if (!contains(val)) {
			set.add(val);
		} else {
			System.out.println("That value is already in the set.");
		}
	}

	@Override public Integer removePos(int Pos) {
		int value = set.get(Pos);
		set.remove(Pos);
		return value;
	}

	@Override public boolean contains(Integer val) {
		for (int i : set) {
			if (i == val) return true;
		}
		return false;
	}

	@Override public int getSize() {
		return set.size();
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

		for (int i : set) {
			out += i + ", ";
		}
		return out;
	}
}
