package ru.job4j.list;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Стек. Первый зашел, первый вышел.
 */
public class SimpleStack<E> implements SimpleArray<E> {

    private int size;
    private Node<E> previous;
    private Node<E> intermediate;

    private static class Node<E> {
        E date;
        Node<E> next;
        Node<E> previous;

        Node(Node<E> previous, E date, Node<E> next) {
            this.date = date;
            this.next = next;
            this.previous = previous;
        }
    }

    public E poll() {
        Node<E> result = this.previous;
        for (int i = size; i > 0; i--) {
            if (i == size) {
                Node<E> inter = new Node<E>(null, get(size - 1), null);
                this.intermediate = inter;
            } else {
                Node<E> inter = new Node<E>(intermediate, get(i), null);
                intermediate.next = inter;
                this.intermediate = inter;
            }
        }
        size--;
        this.previous = this.intermediate;
        return result.date;
    }

    public void add(E value) {
        if (size == 0) {
            Node<E> newLink = new Node<E>(null, value, null);
            this.previous = newLink;
            this.size++;
        } else {
            Node<E> newLink = new Node<E>(previous, value, null);
            previous.next = newLink;
            previous = newLink;
            this.size++;
        }
    }

    public E get(int index) {
        Node<E> result = this.previous;
        for (int i = 0; i < index; i++) {
            result = result.previous;
        }
        return result.date;
    }

    @Override
    public ListIterator<E> iterator() {
        return new ListIterator<E>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (index >= 0 && index < size) {
                    result = true;
                    index++;
                }
                return result;
            }

            @Override
            public E next() {
                E result = null;
                if (index >= 0 && index < size) {
                    result = get(index);
                    index++;
                }
                return result;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public E previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(E e) {

            }

            @Override
            public void add(E e) {

            }
        };
    }
}
