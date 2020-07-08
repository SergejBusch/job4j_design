package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private final int[] data;
    private int point = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length && nextEven(false) != -1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return nextEven(true);
    }

    private int nextEven(boolean pointIncrease) {
        for (int i = point; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                point = pointIncrease ? i + 1 : point;
                return data[i];
            }
        }
      return -1;
    }
}
