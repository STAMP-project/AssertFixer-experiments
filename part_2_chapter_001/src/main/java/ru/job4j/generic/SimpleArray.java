package ru.job4j.generic;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Универсальная обертка над массивом.
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private int size = 1;
    private T[] array;


    public void addModel(T model) {
        if (size == 1) {
            array = (T[]) new Object[size];
            array[size - 1] = model;
            size++;
        } else {
            array = Arrays.copyOf(array, size);
            array[size - 1] = model;
            size++;
        }
    }

    public boolean setModel(int index, T model) {
        boolean result = false;
        if (index < size) {
            array[index] = model;
            result = true;
        }
        return result;
    }

    public void deleteModel(int index) {
        if (index < size) {
            System.arraycopy(this.array, index + 1, array, index, size - index - 2);
            size--;
        }

    }

    public T getModel(int index) {
        return array[index];
    }

    public T[] getBase() {
        return this.array;
    }

    public int getSize() {
        return array.length;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (index < size - 1) {
                    result = true;
                }
                return result;
            }

            @Override
            public T next() {
                T result = null;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                result = array[index];
                index++;
                return result;
            }
        };
    }
}
