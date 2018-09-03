package ru.job4j.array;

/**
 * Куда же без пузырька?
 */

public class BubbleSort {
    public int[] sort(int[] array) {
        int i = 0;
        int j = 0;
        int bufferVar = 0;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    bufferVar = array[j];
                    array[j] = array[i];
                    array[i] = bufferVar;
                }
            }
        }
        return array;
    }

}
