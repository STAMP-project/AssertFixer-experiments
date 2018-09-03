package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ThreadSafe
public class LinkedList<E> implements List<E> {


    protected static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @GuardedBy("this")
    Node<E> first;
    @GuardedBy("this")
    Node<E> last;
    private int size = 0;
    private int index = 0;
    private int modCount = 0;


    synchronized void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    synchronized Node<E> node(int index) {

        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }


    synchronized public E removeFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    synchronized private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        modCount++;
        return element;
    }

    synchronized public E removeLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }

    synchronized private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
        modCount++;
        return element;
    }


    public void add(E value) {
        linkLast(value);
    }

    @Override
    public E get(int index) {
        return (E) node(index).item;
    }

    @Override
    public Iterator iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount == modCount) {
                    return node(index) != null;
                } else {
                    throw new ConcurrentModificationException(
                            "Concurrent Modification Exception");
                }
            }

            @Override
            public E next() {
                if (expectedModCount == modCount) {
                    E result = (E) node(index).item;
                    index++;
                    return result;
                } else {
                    throw new ConcurrentModificationException(
                            "Concurrent Modification Exception");
                }
            }
        };
        return iterator;
    }
}
