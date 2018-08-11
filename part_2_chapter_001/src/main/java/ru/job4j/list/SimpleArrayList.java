package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Класс реализует односвязный список каждый элемент имеет ссылку на следующий.
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;
    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }
    /**
     * Метод удаления первого элемента в списке.
     */
    public void delete() {
        this.first = this.first.next;
        size--;
    }
    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }
    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}
