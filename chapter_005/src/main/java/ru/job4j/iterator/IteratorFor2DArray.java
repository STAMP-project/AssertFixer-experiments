package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorFor2DArray implements Iterator {

    private int point = 0;
    private int[][] data;
    private int size;

    public IteratorFor2DArray(int[][] data) {
        this.data = data;
        this.size = countElements(data);
    }

    private int countElements(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            count += row.length;
        }
        return count;
    }

    @Override
    public Integer next() {
        int nextPoint = 0;
        for (int[] innerArray : data) {
            for (int cell : innerArray) {
                if (nextPoint++ == point) {
                    point++;
                    return cell;
                }
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNext() {
        return point != size;
    }
}