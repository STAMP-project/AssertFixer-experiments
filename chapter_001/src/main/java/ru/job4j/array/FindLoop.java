package ru.job4j.array;
/**FindLoop.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rsl = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index : data) {
            if (data[index] == el) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}