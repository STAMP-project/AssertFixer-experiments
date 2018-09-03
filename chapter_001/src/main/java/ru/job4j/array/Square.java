package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rsl = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rsl[i - 1] = i * i;
        }
        return rsl;
    }
}
