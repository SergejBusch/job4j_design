package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length && nextEven();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

    private boolean nextEven() {
        for (int i = point; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                point = i;
                return true;
            }
        }
      return false;
    }
}
