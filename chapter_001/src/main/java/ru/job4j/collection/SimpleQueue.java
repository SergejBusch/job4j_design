package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (in.isEmpty()) {
            throw new NoSuchElementException();
        }
        T result = null;
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            if (!out.isEmpty()) {
                result = out.pop();
            }
        return result;
    }

    public void push(T value) {
        in.push(value);
    }
}