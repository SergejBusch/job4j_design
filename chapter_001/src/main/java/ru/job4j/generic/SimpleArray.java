package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int modf = 0;

    public SimpleArray(int size) {
        if (size <= 0) {
           throw new ArrayIndexOutOfBoundsException("The size should be more than 0.");
        }
        this.objects = new Object[size];
    }

    public boolean add(T model) {
        Objects.checkIndex(index, objects.length);
        this.objects[index++] = model;
        modf++;
        return true;
    }

    public boolean set(int in, T model) {
        checkIndex(in);
        objects[in] = model;
        return true;
    }

    public boolean remove(int in) {
        checkIndex(in);
        if (index - 1 > in) {
            System.arraycopy(this.objects, in + 1, this.objects, in, this.objects.length - 1 - in);
        } else {
        this.objects[in] = null;
        }
        modf++;
        index--;
        return true;
    }

    public T get(int in) {
        checkIndex(in);
        return (T) objects[in];
    }

    private boolean checkIndex(int in) {
        Objects.checkIndex(in, index);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final int modification = modf;
            private int cursor = 0;
            @Override
            public boolean hasNext() {
                isModified();
                return cursor < index;
            }

            @Override
            public T next() {
                isModified();
                if (cursor > index) {
                    throw new NoSuchElementException();
                }
                return (T) objects[cursor++];
            }

            private void isModified() {
                if (modification != modf) {
                    throw new IllegalStateException();
                }
            }
        };
    }
}

