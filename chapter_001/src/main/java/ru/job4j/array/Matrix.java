package ru.job4j.array;
/**Matrix.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class Matrix {
    int[][] multiple(int size) {
        int[][] rst = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rst[i][j] = (i + 1) * (j + 1);
            }
        }
        return rst;
    }
}