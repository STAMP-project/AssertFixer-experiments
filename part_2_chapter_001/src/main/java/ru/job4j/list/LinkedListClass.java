package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Контейнер на базе связанного списка.
 */
import java.util.ConcurrentModificationException;

public class LinkedListClass<E> {

    private int modification = 0;
    private int modificationConcurrent = 0;
    private int size;
    private Node<E> previous;

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

    public void add(E date) {
        if (modification == 0) {
            Node<E> newLink = new Node<E>(null, date, null);    // создание нового элемента
            this.previous = newLink;                                         // first ссылка на предыдущий объект
            this.size++;
            modification++;                                    // увеличение размера контейнера
        } else {
            Node<E> newLink = new Node<E>(previous, date, null);
            previous.next = newLink;
            previous = newLink;
            this.size++;
            modification++;
        }
    }
    /**
     * Реализовать метод удаления первого элемент в списке.
     * первый меняется на второй
     * во втором удаляется ссылка на первый
     * все последующие сдвигаются через цикл
     *
     */
    public void delete() {
        Node<E> newLink = new Node<E>(null, get(size - 1), null);
        for (int i = size; i < 0; i--) {
            Node<E> first = new Node<E>(newLink, get(i), null);
            newLink.next = first;
            previous = newLink;
        }
    }
    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.previous;
        for (int i = 0; i < index; i++) {
            result = result.previous;
        }
        return result.date;
    }
    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }


    public void checkForModification() {
        if (modification != modificationConcurrent) {
            throw new ConcurrentModificationException("ConcurrentModificationException");
        }
    }
}
