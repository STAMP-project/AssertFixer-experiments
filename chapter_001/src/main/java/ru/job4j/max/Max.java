package ru.job4j.max;
/**
 * Maximum
 *
 * @author Sergey Petrov (sergey45684745@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Max {
    public int max(int a, int b) {
       return  a > b ? a : b;
    }
    public int max(int a, int b, int c) {
        return max(max(a, b), c);
    }
}
