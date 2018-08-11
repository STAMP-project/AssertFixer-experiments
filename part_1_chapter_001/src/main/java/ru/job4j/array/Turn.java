package ru.job4j.array;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Переворачивает массив задом наперед.
 */
public class Turn {
    public int[] turn(int[] array) {
        int a = 0;
        int b = array.length - 1;
        for (int index = 0; index < (array.length / 2); index++) {
            int one = array[a];
            int two = array[b];
            array[b] = one;
            array[a] = two;
            a++;
            b--;
        }
        return array;
    }
}