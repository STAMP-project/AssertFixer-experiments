package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSetConnectedList<E> implements Iterable<E> {

    private int size;
    private int index;
    private Node<E> head;
    private Node<E> tail;

    private static class Node<E> {

        E date;
        Node<E> previous;
        Node<E> next;

        Node(Node<E> previous, E date, Node<E> next) {
            this.date = date;
            this.previous = previous;
            this.next = next;
        }
    }

    public void add(E value) {
        if (validate(value)) {
            if (size == 0) {
                Node<E> newLink = new Node<E>(null, value, null);
                this.head = newLink;
                size++;
            } else if (size == 1) {
                Node<E> newLink = new Node<E>(head, value, null);
                this.head.next = newLink;
                this.tail = newLink;
                this.size++;
            } else {
                Node<E> newLink = new Node<E>(tail, value, null);
                this.tail.next = newLink;
                this.tail = newLink;
                this.size++;
            }
        }
    }

    public E get(int index) {
        Node<E> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    private boolean validate(E value) {
        boolean result = true;
        Node<E> valid = this.head;
        for (int i = 0; i < size; i++) {
            if (valid.date == value) {
                result = false;
                break;
            }
            valid = valid.next;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (index < size) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = get(index);
                index++;
                return result;
            }
        };
    }
}
