package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Динамический список на базе массива.
 */
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DinamicContainer<E extends Object> implements Iterator<E> {

    private int indexIterator = 0;          //индекс итератора
    private int modification = 0;           //внесение изменений
    private int modificationConcurrent = 0; //индекс сравнения изменений
    private int indexContainer = 1;         //вместимость массива
    private E[] container;

    public void add(E value) {
        if (modification == 0) {
            E[] interval = (E[]) new Object[1];
            interval[modification] = value;
            this.container = interval;
            modification++;
            indexContainer++;
        } else {
            E[] interval = Arrays.copyOf(container, indexContainer);
            interval[modification] = value;
            this.container = interval;
            modification++;
            indexContainer++;
        }
    }

    public Object get(int index) {
        return container[index];
    }

    public boolean change() {
        boolean result = false;
        if (modificationConcurrent != modification) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if (indexIterator == 0) {
            modificationConcurrent = modification;
        }
        if (change()) {
            throw new ConcurrentModificationException("ConcurrentModificationException");
        }
        boolean result = false;
        if (indexIterator < modification) {
            result = true;
            indexIterator++;
        }
        return result;
    }

    @Override
    public E next() {
        if (indexIterator == 0) {
            modificationConcurrent = modification;
        }
        if (change()) {
            throw new ConcurrentModificationException("ConcurrentModificationException");
        }
        E result = container[indexIterator];
        indexIterator++;
        return result;
    }
}
