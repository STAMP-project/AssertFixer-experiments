package ru.job4j.list;

public class Cyclicity<E> {

    public boolean hasCycle(Node<E> first) {
        boolean result = false;
        Node<E> node = first;
        Node<E> next = first.next;
        int index = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = index; j > 0; j--) {
                if (node == next) {
                    result = true;
                    break;
                }
                node = node.next;
            }
            next = next.next;
            node = first;
            if (next == null || result) {
                break;
            }
            index++;
            i = 0;
        }
        return result;
    }
}


