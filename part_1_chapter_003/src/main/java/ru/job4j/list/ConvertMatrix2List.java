package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Конвертация двухмерного массива в List.
 */
import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] one : array) {
            for (int two : one) {
                list.add(two);
            }
        }
        return list;
    }
}
