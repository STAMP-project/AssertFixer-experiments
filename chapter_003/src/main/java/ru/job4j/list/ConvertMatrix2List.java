package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**ConvertMatrix2List.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
class ConvertMatrix2List {
    List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] innerArray : array) {
            for (int data : innerArray) {
                list.add(data);
            }
        }
        return list;
    }
}