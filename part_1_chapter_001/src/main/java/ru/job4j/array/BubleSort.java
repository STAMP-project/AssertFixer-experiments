package ru.job4j.array;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Сортировка массива целых чисел, используя алгоритм сортировки пузырьком.
 */
public class BubleSort {
    public int[] buble(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int g = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = g;
                }
            }
        }
        return array;
    }
}


