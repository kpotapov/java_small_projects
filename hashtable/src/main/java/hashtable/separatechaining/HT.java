package hashtable.separatechaining;

import java.util.*;

/**
 * implements hashtable - separate chaining
 * probe sequences Linear probing
 * partial implementation
 */
public class HT<K, V> extends Dictionary<K, V> {

	private final ArrayList<List<Entry<K,V>>> keys;
	private final int                size;

	public HT(int size) {
		this.size = size;
		keys = new ArrayList<List<Entry<K,V>>>(size);
		for (int i = 0; i < size; i++) {
			keys.add(new ArrayList<Entry<K,V>>());
		}
	}

	public int size() {
		int result = 0;
		for (int i = 0; i < keys.size(); i++) {
			result += keys.get(i).size();
		}
		return result;
	}

	public boolean isEmpty() {
		for (int i = 0; i < keys.size(); i++) {
			if (keys.get(i).size() > 0) {
				return false;
			}
		}
		return true;
	}

	public Enumeration<Entry<K,V>> entries() {
		List<Entry<K,V>> result = new ArrayList<Entry<K, V>>();
		for (int i = 0; i < keys.size(); i++) {
			List<Entry<K, V>> list = keys.get(i);
			result.addAll(list);
		}
		final Iterator<Entry<K,V>> iterator = result.iterator();
		return new Enumeration<Entry<K,V>>() {
			public boolean hasMoreElements() {
				return iterator.hasNext();
			}

			public Entry<K,V> nextElement() {
				return iterator.next();
			}

			public Iterator<Entry<K,V>> asIterator() {
				return iterator;
			}
		};
	}

	public Enumeration<K> keys() {
		ArrayList<K> result = new ArrayList<K>();

		Enumeration<Entry<K, V>> entries = entries();
		while (entries.hasMoreElements()) {
			Entry<K, V> kvEntry = entries.nextElement();
			result.add(kvEntry.getK());
		}

		final Iterator<K> iterator = result.iterator();
		return new Enumeration<K>() {
			public boolean hasMoreElements() {
				return iterator.hasNext();
			}

			public K nextElement() {
				return iterator.next();
			}

			public Iterator<K> asIterator() {
				return iterator;
			}
		};
	}

	public Enumeration<V> elements() {
		ArrayList<V> result = new ArrayList<V>();

		Enumeration<Entry<K, V>> entries = entries();
		while (entries.hasMoreElements()) {
			Entry<K, V> kvEntry = entries.nextElement();
			result.add(kvEntry.getV());
		}

		final Iterator<V> iterator = result.iterator();
		return new Enumeration<V>() {
			public boolean hasMoreElements() {
				return iterator.hasNext();
			}

			public V nextElement() {
				return iterator.next();
			}

			public Iterator<V> asIterator() {
				return iterator;
			}
		};
	}

	public V get(Object key) {
		V       result;
		int     position = getPosition(key);
		List<Entry<K,V>> list     = keys.get(position);
		Entry<K, V> kvEntry = entryListContainsKey(list, key);

		if (kvEntry.getK() == null) {
			result = null;
		} else {
			result = kvEntry.getV();
		}
		return result;
	}

	private Entry<K, V> entryListContainsKey(List<Entry<K, V>> list, Object key) {
		for (int i = 0; i < list.size(); i++) {
			Entry<K, V> kvEntry = list.get(i);
			if (kvEntry.getK().equals(key)) {
				return kvEntry;
			}
		}
		return new Entry<K,V>(null,null);
	}

	private int getPosition(Object key) {
		return key.hashCode() % size;
	}

	public V put(K key, V value) {
		V       result;
		int     position = getPosition(key);
		List<Entry<K,V>> list     = keys.get(position);

		Entry<K, V> kvEntry = entryListContainsKey(list, key);

		if (kvEntry.getK() != null) {
			result = kvEntry.getV();
			list.remove(kvEntry);
			list.add(new Entry<K,V>(key,value));
		} else {
			result = null;
			list.add(new Entry<K,V>(key,value));
		}
		return result;
	}

	public V remove(Object key) {
		V       result;
		int     position = getPosition(key);
		List<Entry<K,V>> list     = keys.get(position);

		Entry<K, V> kvEntry = entryListContainsKey(list, key);

		if (kvEntry.getK() != null) {
			result = kvEntry.getV();
			list.remove(kvEntry);
		} else {
			result = null;
		}
		return result;
	}
}
