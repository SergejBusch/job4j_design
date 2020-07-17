package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int modCount = 0;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            modCount++;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        modCount++;
        size++;
        tail.next = node;
    }

    public T deleteFirst() {
        ifHeadIsNull();
        Node<T> tmp = head;
        head = tmp.next;
        tmp.next = null;
        modCount++;
        size--;
        return tmp.value;
    }

    public T deleteLast() {
        ifHeadIsNull();
        if (size == 1) {
            modCount++;
            size--;
            T value = head.value;
            head = null;
            return value;
        }
        Node<T> tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        modCount++;
        size--;
        T value = tmp.next.value;
        tmp.next = null;
        return value;
    }

    private void ifHeadIsNull() {
        if (head == null) {
            throw new NoSuchElementException();
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final int modified = modCount;
            private Node<T> node = head;
            private int index = 0;

            @Override
            public boolean hasNext() {
                isModified();
                return index < size;
            }

            @Override
            public T next() {
               isModified();
               ifNoNext();
               T value = node.value;
               node = node.next;
               index++;
               return value;
            }

            private void isModified() {
                if (modified != modCount) {
                    throw new ConcurrentModificationException();
                }

            }

            private void ifNoNext() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}