package cpsc2150.interfaces;

/**
 * Correspondence this = set[0...MAX_SIZE]
 */
public class ArraySet<T> extends SetAbs<T> implements ISet<T>{

	private T[] set;
	/**
	 * @pre
	 * set exists
	 * @post
	 * initialized set
	 */
	@SuppressWarnings("unchecked")
	public ArraySet() {
		set = (T[]) new Object[ISet.MAX_SIZE];
	}

	@Override public void add(T val) {
		// check for duplicates
		if (!contains(val)) {
			set[getSize()] = val;
		} else {
			System.out.println("That value is already in the set.");
		}
	}

	@Override public T removePos(int Pos) {
		T value = set[Pos];
		for (int i = Pos; i < getSize(); i++) {
			set[i] = set[i + 1];
			set[i + 1] = null;
		}
		return value;
	}

	@Override public boolean contains(T val) {
		for (int i = 0; i < getSize(); i++) {
			if (set[i].equals(val)) return true;
		}
		return false;
	}

	@Override public int getSize() {
		int count = 0;
		for (Object i : set) {
			if (i != null)
				count++;
		}
		return count;
	}
}
