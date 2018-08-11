package ru.job4j.set;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {

    SimpleSet test = new SimpleSet();

    @Test(expected = NoSuchElementException.class)
    public void whenHasCycle() {
        test.add(1);
        test.add(2);
        test.add(2);
        test.add(3);
        test.add(1);
        test.add(4);
        assertThat(test.iterator().next(), is(1));
        assertThat(test.iterator().next(), is(2));
        assertThat(test.iterator().next(), is(3));
        assertThat(test.iterator().next(), is(4));
        test.iterator().next();
    }
}
