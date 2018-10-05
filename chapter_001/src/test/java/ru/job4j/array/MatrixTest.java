package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * MatrixTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class MatrixTest {
    /**
     * Test multiple.
     */
    @Test
    public void whenSizeThenMultipleTable() {
        int testSize = 3;
        int[][] expected = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        Matrix testArray = new Matrix();
        int[][] result = testArray.multiple(testSize);
        assertThat(result, is(expected));
    }
}