package ru.job4j.array;
/**Turn.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class Turn {
    public int[] back(int[] array) {
        int j;
        for (int i = 1; i <= array.length / 2; i++) {
            j = array[i - 1];
            array[i - 1] = array[array.length - i];
            array[array.length - i] = j;
        }
        return array;
    }
}