package ru.job4j.list;

public class SimpleStack<E> extends LinkedList {
    LinkedList<E> listContainer = new LinkedList<>();
    int countDown = 0;

    public SimpleStack() {
        super();

    }

    public E poll() {

        return (E) listContainer.removeLast();
    }

    public void push(E value) {
        listContainer.add(value);
    }
}
