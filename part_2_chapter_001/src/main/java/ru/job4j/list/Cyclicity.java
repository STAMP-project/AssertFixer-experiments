package ru.job4j.list;

public class Cyclicity<E> {


    Node first = new Node(1);
    Node two = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);
    int size = 4;


    public static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public boolean hasCycle(Node<E> first) {
        boolean result = false;
        Node<E> one = first;
        Node<E> two = first.next;
        for (int i = 0; i < 3; i++) {
            E oneE = one.value;
            for (int j = 0; j < size; j++) {
                E twoE = two.value;
                if (oneE == twoE) {
                    result = true;
                    break;
                }
                two = two.next;
                if (two == null) {
                    break;
                }
            }
            one = one.next;
            two = one.next;
            size--;
        }
        return result;
    }
}


