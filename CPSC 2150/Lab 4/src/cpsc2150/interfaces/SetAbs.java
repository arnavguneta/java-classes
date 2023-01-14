package cpsc2150.interfaces;

import java.util.ArrayList;
import java.util.List;

public abstract class SetAbs<T> implements ISet<T> {

	public abstract void add(T val);
	public abstract T removePos(int Pos);
	public abstract boolean contains(T val);
	public abstract int getSize();

	/**
	 * @pre
	 * set is initialized
	 * @post
	 * string containing all values of the set
	 * @return a string that contains all values of the set separated by commas.
	 */
	public String toString() {
		List<T> temp = new ArrayList<>();
		int size = this.getSize();
		String out = "";

		// gets all values of the caller set
		for (int i = 0; i < size; i++) {
			temp.add(this.removePos(0));
		}

		// repopulates the caller set and prints out the set
		for (T i : temp) {
			this.add(i);
			out += i + ", ";
		}

		return out;
	}

	/**
	 * @pre set is initialized
	 * @post true iff this == o
	 * @param o the comparee
	 * @return true if the caller set contains the same values as the comparee set, order does not matter
	 */
	public boolean equals(Object o) {
		if (o instanceof ISet) {
			List<T> tempThis = new ArrayList<>();
			List<T> tempComparee = new ArrayList<>();
			@SuppressWarnings("unchecked")
			ISet<T> temp = (ISet<T>) o;
			int thisSize = this.getSize(), compareeSize = temp.getSize(), count = 0;

			// gets all values of the caller set
			for (int i = 0; i < thisSize; i++) {
				tempThis.add(this.removePos(0));
			}

			// repopulates the caller set and prints out the set
			for (T i : tempThis) {
				this.add(i);
			}

			// gets all values of the comparee set
			for (int i = 0; i < thisSize; i++) {
				tempComparee.add(temp.removePos(0));
			}

			// repopulates the caller set and prints out the set
			for (T i : tempComparee) {
				temp.add(i);
			}

			// checks to see how many similarities there are
			for (T i : tempThis) {
				if (temp.contains(i)) {
					count++;
				}
			}

			// return o to its normal state
			o = temp;

			// if the amount of similarities equals the size, and the sizes are the same, the two sets are equal
			if (count == thisSize && thisSize == compareeSize) {
				return true;
			}
		}
		return false;
	}
}
