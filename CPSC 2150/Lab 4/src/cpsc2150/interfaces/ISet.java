package cpsc2150.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * A container of values, doesn't store duplicates
 * Initialization Ensures: Set is initialized with appropriate size of MAX_SIZE.
 * Defines: MAX_SIZE
 * Constraints: 0 <= MAX_SIZE <= 100
 */
public interface ISet<T> {
	public static final int MAX_SIZE = 100;

	/**
	 * @param val value to be added
	 * @pre getSize() < MAX_SIZE
	 * @post adds value to set if not already added
	 */
	void add(T val);

	/**
	 * @param Pos the index of the value to be removed
	 * @return value of the removed index is returned
	 * @pre getSize() > 0 && 0 <= Pos < getSize()
	 * @post position at index Pos is removed and value returned
	 */
	T removePos(int Pos);

	/**
	 * @param val value to be searched for in the set
	 * @return true if the value is found to be contained by the set, and vice versa
	 * @pre set is initialized
	 * @post true = val in set, false = val not in set
	 */
	boolean contains(T val);

	/**
	 * @return the size of the set (all nonzero values)
	 * @pre set is initialized
	 * @post size of set
	 */
	int getSize();

	/**
	 * @param unionWith the second set
	 * @pre both sets are defined
	 * @post the union of two sets
	 */
	default void union(ISet<T> unionWith) {
		List<T> tempList = new ArrayList<>();
		int unionSize = unionWith.getSize();

		// gets all values for the union set
		for (int i = 0; i < unionSize; i++) {
			tempList.add(unionWith.removePos(0));
		}

		// adds them to the caller set
		for (T i : tempList) {
			if (!this.contains(i)) {
				this.add(i);
			}
		}
	}

	/**
	 * @param intWith second set
	 * @pre both sets are defined
	 * @post the interest of two sets
	 */
	default void intersect(ISet<T> intWith) {
		List<T> tempIntList = new ArrayList<>();
		List<T> tempThisList = new ArrayList<>();
		int intSize = intWith.getSize();
		int thisSize = this.getSize();

		// gets all values of the int set
		for (int i = 0; i < intSize; i++) {
			tempIntList.add(intWith.removePos(0));
		}

		// gets all values of the caller set
		for (int i = 0; i < thisSize; i++) {
			tempThisList.add(this.removePos(0));
		}

		// only keeps the similarities between the caller and int set
		for (T i : tempIntList) {
			if (tempThisList.contains(i)) {
				this.add(i);
			}
		}
	}

	/**
	 * @param diff second set
	 * @pre both sets are defined
	 * @post the difference of two sets
	 */
	default void difference(ISet<T> diff) {
		List<T> tempDiffList = new ArrayList<>();
		List<T> tempThisList = new ArrayList<>();
		List<T> tempIntList = new ArrayList<>();
		int diffSize = diff.getSize(), thisSize = this.getSize(), intSize;

		// gets all values of the caller set
		for (int i = 0; i < thisSize; i++) {
			tempThisList.add(this.removePos(0));
		}

		// repopulates the caller set so intersect function works
		for (T i : tempThisList) {
			this.add(i);
		}

		// gets all values of the diff set
		for (int i = 0; i < diffSize; i++) {
			tempDiffList.add(diff.removePos(0));
		}

		// repopulates the diff set so intersect function works
		for (T i : tempDiffList) {
			diff.add(i);
		}

		// gets intersect
		this.intersect(diff);
		intSize = this.getSize();

		// gets all values of the intersect
		for (int i = 0; i < intSize; i++) {
			tempIntList.add(this.removePos(0));
		}

		// removes the intersect values from caller list and diff list
		for (T i : tempIntList) {
			tempThisList.remove(i);
			tempDiffList.remove(i);
		}

		// merges the difference of the caller and diff list
		for (int i = 0; i < tempThisList.size(); i++) {
			this.add(tempThisList.get(i));
		}

		for (int i = 0; i < tempDiffList.size(); i++) {
			this.add(tempDiffList.get(i));
		}
	}
}
