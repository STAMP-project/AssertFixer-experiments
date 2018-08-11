package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E> implements Iterable<E> {

    private E[] values;
    private int indexMassive = 1;
    private int indexIterator = 0;

    public void add(E value) {
        if (validate(value)) {
            if (indexMassive == 1) {
                values = (E[]) new Object[indexMassive];
                values[indexMassive - 1] = value;
                indexMassive++;
            } else {
                values = Arrays.copyOf(values, indexMassive);
                values[indexMassive - 1] = value;
                indexMassive++;
            }
        }
    }

    private boolean validate(E value) {
        boolean result = true;
        if (indexMassive > 1) {
            for (int i = 0; i < indexMassive - 1; i++) {
                if (values[i] == value) {
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (indexIterator < indexMassive - 1) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = values[indexIterator];
                indexIterator++;
                return result;
            }
        };
    }
}
