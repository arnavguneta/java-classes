package cpsc2150.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Correspondence this = set[0...MAX_SIZE]
 *
 */
public class ListSet<T> extends SetAbs<T> implements ISet<T>{

	private List<T> set;
	/**
	 * @pre
	 * set exists
	 * @post
	 * initialized set
	 */
	public ListSet() {
		set = new ArrayList<>(ISet.MAX_SIZE);
	}

	@Override public void add(T val) {
		// check for duplicates
		if (!contains(val)) {
			set.add(val);
		} else {
			System.out.println("That value is already in the set.");
		}
	}

	@Override public T removePos(int Pos) {
		T value = set.get(Pos);
		set.remove(Pos);
		return value;
	}

	@Override public boolean contains(T val) {
		for (T i : set) {
			if (i.equals(val)) return true;
		}
		return false;
	}

	@Override public int getSize() {
		return set.size();
	}



}
