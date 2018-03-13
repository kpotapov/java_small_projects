package hashtable.openaddressing;

import org.junit.Test;
import scala.collection.mutable.HashTable;

import static org.junit.Assert.*;

public class HTATest {

	Integer one        = i(1);
	Integer eleven     = i(11);
	Integer twenty_one = i(21);
	Integer i99 = i(99);
	Integer i9 = i(9);

	private Integer i(int i) {
		return Integer.valueOf(i);
	}

	@Test
	public void size() {
		{
			HTA<Integer, Integer> hta = new HTA<>();
			assertEquals(0, hta.size());
			assertTrue(hta.isEmpty());
		}
		{
			java.util.Hashtable<Integer,Integer> jht= new java.util.Hashtable<Integer,Integer>(1);
			HTA<Integer, Integer> hta = new HTA<>(1);
			assertEquals(0, hta.size());
			assertTrue(hta.isEmpty());

			assertEquals(0, jht.size());
			assertTrue(jht.isEmpty());


			hta.put(1,1);
			jht.put(1,1);
			assertEquals(1, hta.size());
			assertFalse(hta.isEmpty());

			assertEquals(1, jht.size());
			assertFalse(jht.isEmpty());

			assertTrue(hta.size() == jht.size());

		}
	}

	@Test
	public void hasCode_test() {
		HTA<Integer, Integer> hta = new HTA<>();
		assertEquals(one, hta.hashFunc(one));
		assertEquals(one, hta.hashFunc(eleven));
		assertEquals(one, hta.hashFunc(twenty_one));
	}

	@Test
	public void get() {

		HTA<Integer, Integer> hta = new HTA<>();
		hta.getBuckets().set(1, new Pair<Integer, Integer>(1, i99));
		hta.getBuckets().set(2, new Pair<Integer, Integer>(11, i9));

		{
			Integer value = hta.get(one);
			assertEquals(i99, value);
		}
		{
			Integer value = hta.get(eleven);
			assertEquals(i9, value);
		}
	}

	@Test
	public void put() {
		Integer i9  = i(9);
		Integer i99 = i(99);

		HTA<Integer, Integer> hta = new HTA<>();
		{
			assertEquals(0, hta.size());
			Integer beforePut = hta.put(one, i99);
			assertNull(beforePut);
			Integer value = hta.get(one);
			assertEquals(i99, value);
			assertEquals(1, hta.size());
		}
		{
			Integer beforePut = hta.put(eleven, i9);
			assertNull(beforePut);
			Integer value = hta.get(eleven);
			assertEquals(i9, value);
			assertEquals(2, hta.size());
		}
	}
}