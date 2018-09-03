package ru.job4j.list;


public class SimpleQueue<E> extends LinkedList {

    LinkedList<E> listContainer = new LinkedList<>();

    public SimpleQueue() {
        super();
    }

    public E poll() {

        return ((E) listContainer.removeFirst());
    }

    public void push(E value) {
       listContainer.add(value);
    }
}
