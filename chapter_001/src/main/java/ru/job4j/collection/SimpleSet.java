package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> data = new SimpleArray<>();

    public void add(T e) {
        if (isDuplicate(e)) {
           return;
        }
        data.add(e);
    }

    private boolean isDuplicate(T e) {
        for (T value : data) {
            if (Objects.equals(value, e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
}
