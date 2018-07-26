package ru.job4j.array;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Наполнение массива степенями чисел.
 */
public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int j = 0;
        for (int i = 1; i <= bound; i++) {
            rst[j] = i * i;
            j++;
        }
        return rst;
    }
}