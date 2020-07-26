package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V>  implements Iterable<K> {
    private Node<K, V>[] hashTable;
    private int defaultSize = 16;
    private float loadFactor = .75f;
    private int tableLength = defaultSize;
    private int size;
    private int modCount;

    public SimpleMap() {
        hashTable = new Node[defaultSize];
    }

    public boolean insert(K key, V value) {
        grow();
        int h = hash(key);
        if (hashTable[h] != null) {
            return false;
        }
        size++;
        modCount++;
        hashTable[h] = new Node<>(key, value);
        return true;
    }

    public V get(K key) {
        int h = hash(key);
        if (!key.equals(hashTable[h])) {
            return null;
        }
        return hashTable[h].value;
    }

    public boolean delete(K key) {
        int h = hash(key);
        if (hashTable[h] != null && key.equals(hashTable[h].getKey())) {
            hashTable[h] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(K key) {
        return key.hashCode() % tableLength;
    }

    private void grow() {
        if (size / hashTable.length > loadFactor) {
            tableLength = hashTable.length * 2;
            var newTable = new Node[tableLength];
            for (Node<K, V> node : hashTable) {
                if (node != null) {
                    int h = hash(node.key);
                    newTable[h] = node;
                }
            }
            hashTable = newTable;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int mod = modCount;
            private int position = 0;

            @Override
            public boolean hasNext() {
                if (mod != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (position < size) {
                    if (hashTable[position] != null) {
                        return true;
                    }
                    position++;
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return hashTable[position++].key;
            }
        };
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
