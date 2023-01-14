package cpsc2150.interfaces;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestListSet {
	int maxSize = ISet.MAX_SIZE;

	private ISet<Integer> MakeASet() {
		return new ListSet<>();
	}

	// testing the add function with the size of 0
	@Test
	public void testAdd_s0() {
		ISet<Integer> set = MakeASet();
		set.add(1);

		assertTrue(set.contains(1));
		assertEquals(set.getSize(), 1);
	}

	// testing the add function with the size of maxSize - 1
	@Test
	public void testAdd_sMAX() {
		ISet<Integer> set = MakeASet();

		for (int i = 1; i < maxSize; i++) {
			set.add(i);
		}
		set.add(maxSize);
		assertTrue(set.contains(maxSize));
		assertEquals(set.getSize(), maxSize);
	}

	// testing the add function in a normal case (non-edge)
	@Test
	public void testAdd_s5() {
		ISet<Integer> set = MakeASet();

		for (int i = 1; i < 5; i++) {
			set.add(i);
		}
		set.add(5);

		assertTrue(set.contains(5));
		assertEquals(set.getSize(), 5);
	}

	// testing the contains function for a normal set (something not in set)
	@Test
	public void testContains_normal_false() {
		ISet<Integer> set = MakeASet();

		for (int i = 1; i <= 5; i++) {
			set.add(i);
		}

		assertFalse(set.contains(6));
	}

	// testing the contains function for a normal set (does contain)
	@Test
	public void testContains_normal_true() {
		ISet<Integer> set = MakeASet();

		for (int i = 1; i <= 5; i++) {
			set.add(i);
		}

		assertTrue(set.contains(5));
	}

	// testing the contains function on an empty set
	@Test
	public void testContains_empty() {
		ISet<Integer> set = MakeASet();

		assertFalse(set.contains(5));
	}

	// testing the equals function on two empty sets
	@Test
	public void testEquals_empty() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();

		assertTrue(set1.equals(set2));
	}

	// testing the equals function on two same normal sets
	@Test
	public void testEquals_true() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();

		for (int i = 1; i <= 5; i++) {
			set1.add(i);
			set2.add(i);
		}

		assertTrue(set1.equals(set2));
	}

	// testing the equals function on two different normal sets
	@Test
	public void testEquals_false() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();

		for (int i = 1; i <= 5; i++) {
			set1.add(i);
		}

		for (int i = 1; i <= 10; i++) {
			set2.add(i);
		}

		assertFalse(set1.equals(set2));
	}

	// testing the union function on two different empty sets
	@Test
	public void testUnion_empty() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();
		ISet<Integer> union = MakeASet();

		set1.union(set2);

		assertEquals(set1, union);
	}

	// testing the union function on two different normal sets (the size of the set1 + set2 exceeds the maxSize)
	@Test
	public void testUnion_normal_maxSize() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();
		ISet<Integer> union = MakeASet();

		for (int i = 1; i < maxSize; i++) {
			set1.add(i);
		}

		for (int i = maxSize; i < maxSize + 10; i++) {
			set2.add(i);
		}

		for (int i = 1; i <= maxSize; i++) {
			union.add(i);
		}

		set1.union(set2);

		assertEquals(set1, union);
	}

	// testing the union function on two different normal sets
	@Test
	public void testUnion_normal() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();
		ISet<Integer> union = MakeASet();

		for (int i = 1; i <= 5; i++) {
			set1.add(i);
		}

		for (int i = 6; i <= 10; i++) {
			set2.add(i);
		}

		for (int i = 1; i <= 10; i++) {
			union.add(i);
		}

		set1.union(set2);

		assertEquals(set1, union);
	}

	// testing the diff function on two different empty sets
	@Test
	public void testDifference_empty() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();
		ISet<Integer> diff = MakeASet();

		set1.difference(set2);

		assertEquals(set1, diff);
	}

	// testing the diff function on two different normal sets
	@Test
	public void testDifference_normal() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();
		ISet<Integer> diff = MakeASet();

		for (int i = 1; i <= 5; i++) {
			set1.add(i);
		}

		for (int i = 5; i <= 10; i++) {
			set2.add(i);
		}

		for (int i = 1; i <= 10; i++) {
			diff.add(i);
		}

		diff.removePos(4);

		set1.difference(set2);

		assertEquals(set1, diff);
	}

	// testing the difference function on two different normal sets (the amount of differences exceeds the maxSize)
	@Test
	public void testDifference_normal_maxSize() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();
		ISet<Integer> union = MakeASet();

		for (int i = 1; i < maxSize; i++) {
			set1.add(i);
		}

		for (int i = maxSize; i < maxSize + 10; i++) {
			set2.add(i);
		}

		for (int i = 1; i <= maxSize; i++) {
			union.add(i);
		}

		set1.union(set2);

		assertEquals(set1, union);
	}

	// testing the intersect function on two different empty sets
	@Test
	public void testIntersect_empty() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();
		ISet<Integer> intersect = MakeASet();

		set1.intersect(set2);

		assertEquals(set1, intersect);
	}

	// testing the intersect function on two different normal sets
	@Test
	public void testIntersect_normal() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();
		ISet<Integer> intersect = MakeASet();

		for (int i = 1; i <= 5; i++) {
			set1.add(i);
		}

		for (int i = 5; i <= 10; i++) {
			set2.add(i);
		}

		intersect.add(5);

		set1.intersect(set2);

		assertEquals(set1, intersect);
	}

	// testing the intersect function on two different normal maxSize sets
	@Test
	public void testIntersect_normal_maxSize() {
		ISet<Integer> set1 = MakeASet();
		ISet<Integer> set2 = MakeASet();
		ISet<Integer> union = MakeASet();

		for (int i = 1; i <= maxSize; i++) {
			set1.add(i);
			set2.add(i);
			union.add(i);
		}

		set1.union(set2);

		assertEquals(set1, union);
	}

}
