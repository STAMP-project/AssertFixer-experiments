package ru.job4j.set;

import ru.job4j.list.LinkedList;

import java.util.Iterator;

public class LinkedSet<E> implements Iterable<E> {
    LinkedList<E> setList = new LinkedList<>();
    public boolean add(E value) {
        boolean result = true;
        while (setList.iterator().hasNext()) {
            if (value.equals(setList.iterator().next())) {
                result = false;
            }
        }
        if (result) {
            setList.add(value);
        }
        return result;
    }
    @Override
    public Iterator<E> iterator() {
        return setList.iterator();
    }
}
