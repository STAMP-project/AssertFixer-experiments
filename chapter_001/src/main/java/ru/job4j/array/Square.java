package ru.job4j.array;
/**Square.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class Square {
    /**
     * Заполняем массив элементами от единицы до bound.
     *
     * @param  bound .
     *
     * @return rst заполненный массив.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }
        return rst;
    }
}