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
public class ContainsTest {
    @Test
    public void whenThereIsSubInTheOriginThenTrue() {
        Contains word = new Contains();
        boolean result = word.contains("Hello", "ell");
        assertThat(result, is(true));
    }
    @Test
    public void whenThereIsNoSubInTheOriginThenFalse() {
        Contains word = new Contains();
        boolean result = word.contains("Hello", "ill");
        assertThat(result, is(false));
    }
}