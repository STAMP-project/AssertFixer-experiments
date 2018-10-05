package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * TurnTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class TurnTest {
    /**
     * Test back.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        int[] expected = {2, 6, 1, 4};
        int[] testArray = {4, 1, 6, 2};
        Turn array = new Turn();
        int[] result = array.back(testArray);
        assertThat(result, is(expected));
    }
    /**
     * Test back.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] testArray = {5, 4, 3, 2, 1};
        Turn array = new Turn();
        int[] result = array.back(testArray);
        assertThat(result, is(expected));
    }
}