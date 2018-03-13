package hashtable.separatechaining;

import java.util.Objects;

/**
 * a container contains a key value pair
 * @param <K>
 * @param <V>
 */
public class Entry<K,V> {
	private final K k;
	private final V v;

	public Entry(K k, V v) {
		this.k = k;
		this.v = v;
	}

	public K getK() {
		return k;
	}

	public V getV() {
		return v;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Entry<?, ?> entry = (Entry<?, ?>) o;
		return Objects.equals(k, entry.k) &&
			   Objects.equals(v, entry.v);
	}

	@Override
	public int hashCode() {

		return Objects.hash(k, v);
	}
}
