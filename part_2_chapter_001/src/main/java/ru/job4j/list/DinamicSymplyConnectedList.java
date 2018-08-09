package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Контейнер на базе связанного списка.
 */
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DinamicSymplyConnectedList<E> implements Iterator<E> {

    private int modification = 0;
    private int modificationConcurrent = 0;
    private int indexIteratorHasNext = 0;
    private int indexIteratorNext = 0;
    private int size;
    private Node<E> first;

    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }

    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modification++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        size--;
        return result.date;
    }

    public boolean change() {
        boolean result = false;
        if (modificationConcurrent != modification) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (indexIteratorHasNext == 0) {
            modificationConcurrent = modification;
        }
        if (change()) {
            throw new ConcurrentModificationException("ConcurrentModificationException");
        }
        if (indexIteratorHasNext < size) {
            result = true;
            indexIteratorHasNext++;
        }
        return result;
    }

    @Override
    public E next() {
        if (indexIteratorNext == 0) {
            modificationConcurrent = modification;
        }
        if (change()) {
            throw new ConcurrentModificationException("ConcurrentModificationException");
        }
        E result = get(indexIteratorNext);
        indexIteratorNext++;
        return result;
    }
}
