package com.ark.ds.lrucache;

/**
 * <p> Interface to define operations supported by LRU Cache. </p>
 * @param <K> - Defines the type of Key
 * @param <V> - Defines the type of Value
 * @author AbdulR
 */
public interface ILRUCache<K,V> {
    void put(K key, V value);
    V get(K key);
    int size();
    boolean isEmpty();
    boolean containsKey(K key);
    void printData();
}
