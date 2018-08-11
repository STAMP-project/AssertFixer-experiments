package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Контейнер на базе связанного списка.
 */
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DinamicSymplyConnectedList<E> implements Iterator<E> {

    private int size;
    private int modification;
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

    public void add(E date) {
        if (size == 0) {
            Node<E> newLink = new Node<E>(null, date, null);
            this.head = newLink;
            size++;
        } else if (size == 1) {
            Node<E> newLink = new Node<E>(head, date, null);
            this.head.next = newLink;
            this.tail = newLink;
            this.size++;
        } else {
            Node<E> newLink = new Node<E>(tail, date, null);
            this.tail.next = newLink;
            this.tail = newLink;
            this.size++;
        }
    }

    public E get(int index) {
        Node<E> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    public boolean change() {
        boolean result = false;
        if (size != modification) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (index == 0) {
            modification = size;
        }
        if (change()) {
            throw new ConcurrentModificationException("ConcurrentModificationException");
        }
        if (index < size) {
            result = true;
            index++;
        }
        return result;
    }

    @Override
    public E next() {
        if (index == 0) {
            modification = size;
        }
        if (change()) {
            throw new ConcurrentModificationException("ConcurrentModificationException");
        }
        E result = get(index);
        index++;
        return result;
    }
}
