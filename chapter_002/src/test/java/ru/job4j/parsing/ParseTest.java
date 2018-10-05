package ru.job4j.parsing;

import org.junit.Test;
import java.util.Stack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ParseTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class ParseTest {
    @Test
    public void whenNormalBracketsThenTrue() {
        Parse line = new Parse();
        String test = "{[}]";
        assertThat(line.validate(test), is(false));
    }
    @Test
    public void whenDifferentOrderThenNormalOrder() {
        String input = "[{}]";
        Parse line = new Parse();
        Stack<Character> expected = new Stack<>();
        expected.add('[');
        expected.add(']');
        expected.add('{');
        expected.add('}');
        assertThat(line.change(input), is(expected));
    }
}