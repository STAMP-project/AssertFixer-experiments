package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SubStringSearchTest
 * First method returns true beacuse there's subString exists.
 * Second method returns false. There's no subString.
 *
 * @author Sergey Petrov (sergey45684745@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SubStringSearchTest {
    @Test
    public void whenStringContainsSubStrThenTrue() {
        SubStringSearch word = new SubStringSearch();
        boolean result = word.contains(
                "I'm going to make him an offer he can't refuse.",
                "make");
        assertThat(result, is(true));
    }
    @Test
    public void whenStringDoesNotContainsSubStrThenFalse() {
        SubStringSearch word = new SubStringSearch();
        boolean result = word.contains(
                "I'm going to make him an offer he can't refuse.",
                "hope");
        assertThat(result, is(false));
    }
}
