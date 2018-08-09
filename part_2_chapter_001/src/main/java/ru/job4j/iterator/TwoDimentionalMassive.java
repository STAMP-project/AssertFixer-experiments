package ru.job4j.iterator;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Итератор для двухмерного массива.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoDimentionalMassive implements Iterator<Integer> {

    private final int[][] massive;
    private int indexOne = 0;
    private int indexTwo = 0;

    TwoDimentionalMassive(int[][] massive) {
        this.massive = massive;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("ConcurrentModificationException");
        }
        int result = massive[indexOne][indexTwo];
        if (indexTwo < massive[indexOne].length - 1) {
            indexTwo++;
        } else if (indexTwo == massive[indexOne].length - 1) {
            indexOne++;
            indexTwo = 0;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        if (indexOne >= massive.length || indexTwo >= massive[indexOne].length) {
            result = false;
        }
        return result;
    }
}