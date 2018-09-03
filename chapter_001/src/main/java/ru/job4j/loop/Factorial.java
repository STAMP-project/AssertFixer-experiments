package ru.job4j.loop;

/**
 * 4.2. Создать программу вычисляющую факториал
 */

public class Factorial {
    long getFactorial(int a) {
        long result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return  result;
    }
}
