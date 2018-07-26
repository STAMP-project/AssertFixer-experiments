package ru.job4j.loop;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Вычисление факториала числа.
 */
public class Factorial {
    public int calc(int n) {
        int result = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
        }
        return result;
    }
}