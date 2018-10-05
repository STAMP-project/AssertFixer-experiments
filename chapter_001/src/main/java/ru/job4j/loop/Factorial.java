package ru.job4j.loop;
/**Factorial.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class Factorial {
    /**
     *Method calc.
     *
     *@param n Positive whole number.
     *
     *@return Number factorial.
     */
    public int calc(int n) {
        int fact = 1;
        while (n > 0) {
            fact = n * fact;
            n--; }
        return fact;
    }
}