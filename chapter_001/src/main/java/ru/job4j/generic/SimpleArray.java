package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        if (size <= 0) {
           throw new ArrayIndexOutOfBoundsException("The size should be more than 0.");
        }
        this.objects = new Object[size];
    }

    public boolean add(T model) {
        checkIndex(index);
        this.objects[index++] = model;
        return true;
    }

    public boolean set(int index, T model) {
        checkIndex(index);
        objects[index] = model;
        return true;
    }

    public boolean remove(int in) {
        checkIndex(in);
        if (this.objects.length - 1 > in) {
            System.arraycopy(this.objects, in + 1, this.objects, in, this.objects.length - 1 - in);
        } else {
        this.objects[in] = null;
        }
        index--;
        return true;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) objects[index];
    }

    private boolean checkIndex(int index) {
        Objects.checkIndex(index, this.objects.length);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) Arrays.stream(this.objects).iterator();
    }

}

