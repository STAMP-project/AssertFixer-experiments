package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * SquareTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class SquareTest {
    /**
     * Test calculate.
     */
    @Test
    public void whenBoundThenArrayElementsAreSquareFromOneToBound() {
        int testBound = 3;
        int[] expected = {1, 4, 9};
        Square testArray = new Square();
        int[] result = testArray.calculate(testBound);
        assertThat(result, is(expected));
    }
}
