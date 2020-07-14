package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements Iterable<E> {
    private int size = 0;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
           node = node.next;

        }
        return node.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> cursor = first;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                isModified();
                ifNoNext();
                var result = cursor;
                cursor = cursor.next;
                return result.item;
            }

            private void isModified() {
                if (expectedModCount != modCount) {
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

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
