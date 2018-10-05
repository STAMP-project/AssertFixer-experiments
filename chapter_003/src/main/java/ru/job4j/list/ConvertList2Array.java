package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**ConvertList2Array.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
class ConvertList2Array {

    private int setSize(List<Integer> list, int rows) {
        int cells;
        if (list.size() % rows != 0) {
            cells = list.size() / rows + 1;
        } else {
            cells = list.size() / rows;
        }
        return cells;
    }

    int[][] toArray(List<Integer> list, int rows) {
        ConvertList2Array array = new ConvertList2Array();
        int cells = array.setSize(list, rows);
        int[][] convertedArray = new int[rows][cells];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (k < list.size()) {
                    convertedArray[i][j] = list.get(k);
                    k++;
                }
            }
        }
        return convertedArray;
    }

    List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] ints : list) {
            for (int j : ints) {
                result.add(j);
            }
        }
        return result;
    }
}