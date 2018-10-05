package ru.job4j.max;
/**Maximum of two numbers.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public class Max {
    /**
     *Method maxOfThree.
     *@param first The first number.
     *@param second The second number.
     *@param third The third number.
     *@return Max of three numbers.
     */
    public int maxOfThree(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
    /**
     *Method max.
     *@param first The first number.
     *@param second The second number.
     *@return Max of two numbers.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
}
