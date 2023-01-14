package cpsc2150.interfaces;

public interface ISet {
	public static final int MAX_SIZE = 100;

	/**
	 * @pre
	 * getSize() < MAX_SIZE
	 * @post
	 * adds value to set if not already added
	 * @param val value to be added
	 */
	void add(Integer val);

	/**
	 * @pre
	 * getSize() > 0 && 0 <= Pos < getSize()
	 * @post
	 * position at index Pos is removed and value returned
	 * @param Pos the index of the value to be removed
	 * @return value of the removed index is returned
	 */
	Integer removePos(int Pos);

	/**
	 * @pre
	 * set is initialized
	 * @post
	 * true = val in set, false = val not in set
	 * @param val value to be searched for in the set
	 * @return true if the value is found to be contained by the set, and vice versa
	 */
	boolean contains(Integer val);

	/**
	 * @pre
	 * set is initialized
	 * @post
	 * size of set
	 * @return the size of the set (all nonzero values)
	 */
	int getSize();
}
