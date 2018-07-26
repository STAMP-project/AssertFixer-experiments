package ru.job4j.iterator;

import java.util.Iterator;

public class EvenNumbers implements Iterator {

    private int[] massive = new int[]{};
    private int indexNext = 0;
    private int indexHasNext = 0;

    EvenNumbers(int[] massive) {
        this.massive = massive;
    }

    @Override
    public Object next() {
        int result = 0;
        for (int i = indexNext; i < massive.length; i++) {
            if (massive[i] % 2 == 0) {
                result = massive[i];
                indexNext = i + 1;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (massive[indexHasNext] % 2 == 0) {
            result = true;
        }
        indexHasNext++;
        return result;
    }
}
