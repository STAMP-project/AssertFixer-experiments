package ru.job4j.array;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Проверяет что все значения в массиве true либо fakse.
 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] != data[index + 1]) {
                    result = false;
            }
        }
        return result;
    }
}