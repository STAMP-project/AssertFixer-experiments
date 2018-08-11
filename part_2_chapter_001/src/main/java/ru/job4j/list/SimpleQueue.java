package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Очередь. Последний зашел, первый вышел.
 */
public class SimpleQueue<E> {

    private int size;
    private Node<E> first;
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
        E result = get(size - 1);
        for (int i = size - 2; i >= 0; i--) {
            if (i == size - 2) {
                Node<E> inter = new Node<E>(null, get(size - 2), null);
                this.intermediate = inter;
            } else {
                Node<E> inter = new Node<E>(intermediate, get(i), null);
                intermediate.next = inter;
                this.intermediate = inter;
            }
        }
        size--;
        this.first = this.intermediate;
        return result;
    }

    public void push(E value) {
        if (size == 0) {
            Node<E> newLink = new Node<E>(null, value, null);
            this.first = newLink;
            this.size++;
        } else {
            Node<E> newLink = new Node<E>(first, value, null);
            first.next = newLink;
            first = newLink;
            this.size++;
        }
    }

    private E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.previous;
        }
        return result.date;
    }
}
