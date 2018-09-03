package ru.job4j.set;

import ru.job4j.list.ArrayList;

import java.util.Iterator;

public class ArraySet<E> implements Iterable<E> {
    ArrayList setList = new ArrayList(3);

    public boolean add(Object value) {
        boolean result = true;
        for (int i = 0; i < setList.size() - 1; i++) {
            try {
                if (value.equals(setList.get(i))) {
                    result = false;
                    break;
                }
            } catch (NullPointerException npe) {
                npe.printStackTrace();
                continue;
            }

        }
        if (result) {
            setList.add(value);
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = setList.iterator();
        return iterator;
    }
}
