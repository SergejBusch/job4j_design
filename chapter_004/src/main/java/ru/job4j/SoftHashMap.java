package ru.job4j;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class SoftHashMap<K, V> {
    private final HashMap<K, SoftReference<V>>  map = new HashMap<>();

    public void put(K key, V value) {
        map.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        var vSoftReference = map.get(key);
        return vSoftReference == null ? null : vSoftReference.get();
    }
}
