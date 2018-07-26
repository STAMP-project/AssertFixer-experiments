package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    SimpleArray<Integer> test = new SimpleArray<Integer>();

    @Before
    public void setUp() {
        test.add(1);
        test.add(2);
        test.add(3);
    }

    @Test
    public void whenIndexTwo() {
        assertThat(test.get(2), is(3));
    }

    @Test
    public void whenDeleteSecondElement() {
        test.delete(1);
        assertThat(test.get(1), is(3));
    }

    @Test
    public void whenSetSecondElement() {
        test.set(1, 5);
        assertThat(test.get(1), is(5));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(test.hasNext(), is(true));
        assertThat(test.next(), is(1));
        assertThat(test.hasNext(), is(true));
        assertThat(test.next(), is(2));
        assertThat(test.hasNext(), is(true));
        assertThat(test.next(), is(3));
        assertThat(test.hasNext(), is(false));
    }
}
