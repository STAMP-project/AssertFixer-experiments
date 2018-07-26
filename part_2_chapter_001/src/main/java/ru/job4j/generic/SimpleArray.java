package ru.job4j.generic;

import java.util.ArrayList;
import java.util.Iterator;

public class SimpleArray<T> implements Iterator {

    private final int maxIndex = 10;
    private int indexIteratorNext = 0;
    private int indexIteratorHasNext = 0;
    private ArrayList<T> array = new ArrayList<T>();


    public void add(T model) {
        if (array.size() <= maxIndex) {
            array.add(model);
        }
    }

    public void set(int index, T model) {
        if (array.size() <= maxIndex) {
            array.set(index, model);
        }
    }

    public void delete(int index) {
        array.remove(index);
    }

    public T get(int index) {
        return array.get(index);
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (indexIteratorHasNext < array.size()) {
            indexIteratorHasNext++;
            result = true;
        }
        return result;
    }

    @Override
    public Object next() {
        T result = array.get(indexIteratorNext);
        try {
            indexIteratorNext++;
        } catch (NullPointerException ex) {

        }
        return result;
    }
}
