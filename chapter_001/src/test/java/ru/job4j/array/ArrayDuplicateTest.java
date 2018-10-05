package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * ArrayDuplicateTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"One", "Three", "Three", "Four", "Three"};
        String[] expected = {"One", "Three", "Four"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, is(expected));
    }
}