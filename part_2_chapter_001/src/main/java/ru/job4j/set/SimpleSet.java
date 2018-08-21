package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E extends Object> implements Iterable<E> {

    private E[] values;
    private int position = 0;

    public SimpleSet(int size) {
        this.values = (E[]) new Object[size];
    }

    public void add(E value) {
        reSize();
        if (validate(value)) {
            values[position] = value;
            position++;
        }
    }

    private boolean validate(E value) {
        boolean result = true;
        if (position > 0) {
            for (int i = 0; i < position; i++) {
                if (values[i] == value) {
                    result = false;
                }
            }
        }
        return result;
    }

    private void reSize() {
        if (position >= values.length) {
            E[] newArray = (E[]) new Object[values.length * 2];
            System.arraycopy(values, 0, newArray, 0, values.length);
            this.values = newArray;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (index < position - 1 && values[index] != null) {
                    result = true;
                    index++;
                }
                return result;
            }

            @Override
            public E next() {
                if (index >= position - 1) {
                    throw new NoSuchElementException();
                }
                E result = null;
                if (index < position - 1 && values[index] != null) {
                    result = values[index];
                    index++;
                }
                return result;
            }
        };
    }
}
