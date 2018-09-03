package ru.job4j.loop;
/**
 * Подсчет суммы чётных чисел в диапазоне
 */

public class Counter {
    public  int add(int start, int finish) {
        int result = 0;
        if (start < finish) {
            for (int i = start; i <= finish; i++) {
                if (i % 2 == 0) {
                    result += i;
                }
            }
        }
        return result;
    }
}
