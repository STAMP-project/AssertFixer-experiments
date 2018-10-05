package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * FindLoopTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class FindLoopTest {
    /**
     * Test indexOf.
     */
    @Test
    public void whenCanFindElementInArrayThenReturnIndex() {
        int[] testArray = {1, 5, 3};
        int neededElement = 5;
        int expected = 1;
        FindLoop array = new FindLoop();
        int result = array.indexOf(testArray, neededElement);
        assertThat(result, is(expected));
    } /**
     * Test indexOf.
     */
    @Test
    public void whenCannotFindAnArrayElementThenReturnMinusOne() {
        int[] testArray = {0, 1, 2};
        int neededElement = 3;
        int expected = -1;
        FindLoop array = new FindLoop();
        int result = array.indexOf(testArray, neededElement);
        assertThat(result, is(expected));
    }
}