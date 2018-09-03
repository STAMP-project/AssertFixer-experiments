package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private int[][] array;
    int cell = 0;
    int row = 0;

    public MatrixIterator(final int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length - 1 > row;
    }

    private boolean horizontalHasNext() {
        return array[row].length > cell;
    }

    public Integer next() {
        Integer result;
        if (!this.horizontalHasNext() && this.hasNext()) {
            row++;
            cell = 0;
        }

        if (!this.hasNext() && !this.horizontalHasNext()) {
            throw new NoSuchElementException("No Such Element");
        }
        result = this.horizontalNext();
        return result;
    }

    private Integer horizontalNext() {
        return array[row][cell++];
    }
}
