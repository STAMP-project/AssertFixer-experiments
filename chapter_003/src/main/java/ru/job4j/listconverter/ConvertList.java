package ru.job4j.listconverter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertList {
    /**
     * в метод приходит двумерный массив целых чисел,
     * необходимо пройтись по всем элементам массива и добавить их в List<Integer>.
     *
     * @param array
     * @return
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] subArray : array) {
            for (int num : subArray) {
                list.add(num);
            }
        }
        return list;
    }

    /**
     * метод toArray должен равномерно разбить лист на количество строк двумерного массива.
     * В методе toArray должна быть проверка - если количество элементов не кратно количеству строк -
     * оставшиеся значения в массиве заполнять нулями.
     *
     * @param list
     * @param rows
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        Iterator<Integer> iterator = list.iterator();
        int cols = list.size() / rows + (list.size() % rows == 0 ? 0 : 1);
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //array[i][j] = 0;
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                }
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] subArray : list
                ) {
            for (int i = 0; i < subArray.length; i++) {
                result.add(subArray[i]);
            }
        }
        return result;
    }
}
