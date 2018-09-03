package ru.job4j.list.nodecycle;

public class Node<T> {
    public T value;
    public Node<T> next;
    public void setNext(Node<T> node) {
        this.next = node;
    }

    public Node(T i) {
        this.value = i;
    }
}
