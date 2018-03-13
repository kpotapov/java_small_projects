package hashtable.openaddressing;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * implements hashtable - open addressing AKA closed hashing
 * probe sequences Linear probing
 * partial implementation
 */
public class HTA<K, V> implements Map<K, V> {

	private ArrayList<Pair<K, V>> buckets;
	private int                   mapSize;

	private static final int DEFAULT_SIZE = 10;
	private int M; //current_size

	public HTA() {
		this(DEFAULT_SIZE);
	}

	public HTA(int m) {
		M = m;
		buckets = new ArrayList<>(M);
		for (int i = 0; i < M; i++) {
			getBuckets().add(null);
		}
	}

	Integer hashFunc(Object k) {
		return k.hashCode() % M;
	}

	@Override
	public int size() {
		return mapSize;
	}

	@Override
	public boolean isEmpty() {
		return mapSize == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public V get(Object key) {
		V          result = null;
		Integer    ix     = hashFunc(key);
		Pair<K, V> pair;
		do {
			pair = getBuckets().get(ix);
			if (pair != null && pair.getK().equals(key)) {
				result = pair.getV();
			} else {
				ix = newPosition(ix);
			}
		} while (result == null && pair != null);

		return result;
	}

	private Integer newPosition(Integer ix) {
		return (ix + 1) % M;
	}

	@Override
	public V put(K key, V value) {
		V result = null;

		Pair<K, V> newPair = new Pair<>(key, value);
		Pair<K, V> pair;

		Integer ix        = hashFunc(key);
		int     count     = 0;
		boolean searching = true;
		do {
			pair = getBuckets().get(ix);
			if (pair == null) {
				getBuckets().set(ix, newPair);
				result = null;
				searching = false;
				mapSize++;
			} else {
				if (pair.getK().equals(key)) {
					getBuckets().set(ix, newPair);
					result = pair.getV();
					searching = false;
				} else {
					ix = newPosition(ix);
				}
			}

			if (count >= M) searching = false;
			else count++;

		} while (searching);

		return result;
	}

	@Override
	public V remove(Object key) {
		return null;
	}

	@Override
	public void putAll(@NotNull Map<? extends K, ? extends V> m) {

	}

	@Override
	public void clear() {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@NotNull
	@Override
	public Set<K> keySet() {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@NotNull
	@Override
	public Collection<V> values() {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@NotNull
	@Override
	public Set<Entry<K, V>> entrySet() {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}


	ArrayList<Pair<K, V>> getBuckets() {
		return buckets;
	}

	@Override
	public String toString() {
		String bucketsString = "";
		for (int i = 0; i < buckets.size(); i++) {
			Pair<K, V> kvPair = buckets.get(i);
			if (null!=kvPair) {
				bucketsString+=kvPair+",";
			}
		}

		final StringBuilder sb = new StringBuilder("HTA{");
		sb.append("buckets=").append(bucketsString);
		sb.append(", mapSize=").append(mapSize);
		sb.append(", M=").append(M);
		sb.append('}');
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		HTA<?, ?> hta = (HTA<?, ?>) o;
		return mapSize == hta.mapSize &&
			   M == hta.M &&
			   Objects.equals(buckets, hta.buckets);
	}

	@Override
	public int hashCode() {
		return Objects.hash(buckets, mapSize, M);
	}
}

