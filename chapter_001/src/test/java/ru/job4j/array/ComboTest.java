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
public class ComboTest {
    /**
     * Test combo.
     */
    @Test
    public void whenCombineTwoArraysThenThirdArray() {
        int[] firstTestArray = {1, 3, 5};
        int[] secondTestArray = {2, 4};
        int[] expected = {1, 2, 3, 4, 5};
        Combo array = new Combo();
        int[] result = array.combo(firstTestArray, secondTestArray);
        assertThat(result, is(expected));
    }
}