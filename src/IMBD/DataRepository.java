package IMBD;

public interface DataRepository<K, V> {
    public K getKey();

    public V getValue();

    public void put(K key, V value);

}