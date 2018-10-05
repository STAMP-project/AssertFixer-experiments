package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * BubbleSortTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class BubbleSortTest {
    /**
     * Test back.
     */
    @Test
    public void whenUnsortedArrayThenSortedArray() {
        int[] testArray = {5, 1, 2, 7, 3};
        int[] expected = {1, 2, 3, 5, 7};
        BubbleSort array = new BubbleSort();
        int[] result = array.sort(testArray);
        assertThat(result, is(expected));
    }
}