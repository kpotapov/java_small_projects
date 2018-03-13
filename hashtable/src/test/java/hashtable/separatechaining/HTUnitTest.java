package hashtable.separatechaining;

import hashtable.separatechaining.HT;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;

import static java.util.Collections.list;
import static org.junit.Assert.*;

public class HTUnitTest {

	@Test
	public void isEmpty() {
		int                  htSize = 11;
		HT<Integer, Integer> ht     = new HT<Integer, Integer>(htSize);
		assertTrue(ht.isEmpty());
		Integer v1 = ht.put(1, 2);
		assertFalse(ht.isEmpty());
	}

	@Test
	public void keys() {
		HT<Integer, Integer> ht = new HT<Integer, Integer>(11);
		ht.put(1, 2);
		ht.put(2, 10);
		ht.put(5, 20);
		ArrayList<Integer> list = list(ht.keys());
		assertTrue(list.contains(1));
		assertTrue(list.contains(2));
		assertTrue(list.contains(5));

	}

	@Test
	public void elements() {
		HT<Integer, Integer> ht = new HT<Integer, Integer>(11);
		ht.put(1, 2);
		ht.put(2, 10);
		ht.put(5, 20);
		ArrayList<Integer> list = list(ht.elements());
		assertTrue(list.contains(2));
		assertTrue(list.contains(10));
		assertTrue(list.contains(20));

	}

	@Test
	public void get() {
		HT<Integer, Integer> ht = new HT<Integer, Integer>(11);

		Integer v1 = ht.put(1, 2);
		Integer v2 = ht.get(1);

		assertEquals(Integer.valueOf(2), v2);
	}

	@Test
	public void put() {
		HT<Integer, Integer> ht = new HT<Integer, Integer>(11);

		// a new value , an empty slot
		Integer v1 = ht.put(1, 2);
		assertNull(v1);

		//same value
		Integer v2 = ht.put(1, 2);
		assertEquals(Integer.valueOf(2), v2);

		// a new value , a busy slot
		Integer v3 = ht.put(1, 2);
		assertEquals(Integer.valueOf(2), v3);

	}

	@Test
	public void remove_from_empty_hashmap() {
		HT<Integer, Integer> ht = new HT<Integer, Integer>(11);

		// a new value , an empty slot
		Integer v1 = ht.remove(1);
		assertNull(v1);
	}

	@Test
	public void remove_add_rm_value() {
		HT<Integer, Integer> ht = new HT<Integer, Integer>(11);

		Integer value1 = 2;
		Integer v1     = ht.put(1, value1);
		assertNull(v1);

		Integer v1_removed = ht.remove(1);
		assertEquals(value1, v1_removed);
	}

	@Test
	public void remove_value_in_full_table() {
		HT<Integer, Integer> ht = new HT<Integer, Integer>(11);

		Integer value1 = 2;
		int     key1   = 1;
		Integer v1     = ht.put(key1, value1);
		assertNull(v1);

		Integer value2 = 4;
		Integer v2     = ht.put(3, value2);
		assertNull(v2);

		Integer v1_removed = ht.remove(key1);
		assertEquals(value1, v1_removed);
	}

	@Test
	public void size_test() {
		int                         amount    = 11;
		Hashtable<Integer, Integer> hashtable = new Hashtable<>(amount);
		HT<Integer, Integer>        ht        = new HT<>(amount);

		for (int i = 0; i < 10; i++) {
			hashtable.put(i, i);
			ht.put(i, i);
			int size   = hashtable.size();
			int actual = ht.size();
			assertEquals(size, actual);
		}
		assertEquals(10, ht.size());
		Integer remove = ht.remove(0);

		assertEquals(Integer.valueOf(0), remove);
		assertEquals(9, ht.size());

	}

}