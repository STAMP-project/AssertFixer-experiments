package ru.job4j.iterator;

import java.util.Iterator;

public class Converter {

    Iterator<Iterator<Integer>> its;
    Iterator<Integer> it;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> iterators) {
        this.its = iterators;
        it = this.its.hasNext() ? this.its.next() : null;

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                boolean result = false;
                try {
                    result = it.hasNext();
                } catch (NullPointerException ex) {
                    result = false;
                }
                return result;
            }

            @Override
            public Integer next() {
                int i = it.next();
                while (it != null && !it.hasNext()) {
                    it = its.hasNext() ? its.next() : null;
                }
                return i;
            }
        };
    }
}


