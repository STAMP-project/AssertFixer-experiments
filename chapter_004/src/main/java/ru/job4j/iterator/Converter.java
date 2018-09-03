package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    private Iterator<Iterator<Integer>> iteratorOfIterator;
    private Iterator<Integer> currentIterator;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.iteratorOfIterator = it;
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                while (currentIterator == null || !currentIterator.hasNext()) {
                    if (!iteratorOfIterator.hasNext()) {
                        return false;
                    }
                    currentIterator = iteratorOfIterator.next();
                }
                return true;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No Such Element");
                }
                return currentIterator.next();
            }
        };
    }
}