package ru.job4j.loop;
/**Sum of even numbers from one number to another.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public class Counter {
    /**
     *Method add.
     *@param start The first number.
     *@param finish The second number.
     *@return Sum of even numbers between start and finish.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (; start <= finish; start++) {
            if (start % 2 == 0) {
                sum += start;
            }
        } return sum;
    }
}