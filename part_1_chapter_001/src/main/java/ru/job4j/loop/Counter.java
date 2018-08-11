package ru.job4j.loop;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Подсчет суммы четных чисел в диапазоне.
 */
public class Counter {

    public int add(int start, int finish) {
        int result = 0;
        for (int  i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result = result + i;
            }
        }
    return result;
    }
}
