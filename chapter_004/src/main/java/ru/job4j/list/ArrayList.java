package ru.job4j.list;

import net.jcip.annotations.*;

import java.util.*;

@ThreadSafe
public class ArrayList<E> implements List {

    private int index = 0;
    @GuardedBy("this")
    private Object[] storage;
    private int capacity = 10;
    private int modCount = 0;

    public synchronized int size() {
        return storage.length;
    }

    public ArrayList() {
        storage = new Object[capacity];
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        storage = new Object[capacity];
    }

    @Override
    public  Iterator iterator() {
        synchronized (this.storage) {
            return new Iterator<E>() {
                final int expectedModCount = modCount;
                int index1 = 0;

                @Override
                public boolean hasNext() {
                    synchronized (this) {
                        if (expectedModCount == modCount) {
                            return storage.length > index1;
                        } else {
                            throw new ConcurrentModificationException("Concurrent Modification Exception");
                        }
                    }
                }

                @Override
                public E next() {
                    synchronized (this) {
                        if (expectedModCount == modCount) {
                            return (E) storage[index1++];
                        } else {
                            throw new ConcurrentModificationException("Concurrent Modification Exception");
                        }
                    }
                }
            };
        }
    }

    @Override
    public synchronized void add(Object value) {
        if (index < capacity) {
            storage[index++] = value;
        } else {
            capacity *= 2;
            storage = Arrays.copyOf(storage, capacity);
            modCount++;
            storage[index++] = value;
        }
    }

    @Override
    public synchronized E get(int index) {
        if (index < storage.length) {
            return (E) storage[index];
        } else {
            return null;
        }
    }
}
