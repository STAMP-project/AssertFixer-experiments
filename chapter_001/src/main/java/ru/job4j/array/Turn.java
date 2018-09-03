package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int buffVar = 0;
        for (int i = 0; i < array.length / 2; i++) {
            buffVar = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = buffVar;
        }
        return array;
    }
}
