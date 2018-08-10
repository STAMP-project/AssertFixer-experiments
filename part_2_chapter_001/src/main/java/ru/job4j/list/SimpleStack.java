package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Стек. Первый зашел, первый вышел.
 */
public class SimpleStack<E> {

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

    public void push(E value) {
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

    private E get(int index) {
        Node<E> result = this.previous;
        for (int i = 0; i < index; i++) {
            result = result.previous;
        }
        return result.date;
    }
}
