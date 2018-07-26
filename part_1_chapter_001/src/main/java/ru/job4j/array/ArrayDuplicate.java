package ru.job4j.array;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Удаление дубликатов в массиве.
 */
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int c = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            for (int t = j; t < array.length - 1; t++) {
                if (array[i] == array[t]) {
                    for (int e =  t; e < array.length - 1; e++) {
                        array[e] = array[e + 1];
                    }
                    c++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - c);
    }
}