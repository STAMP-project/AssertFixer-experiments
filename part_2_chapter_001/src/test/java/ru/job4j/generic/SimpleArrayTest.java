package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    SimpleArray<Integer> test = new SimpleArray<Integer>();

    @Before
    public void setUp() {
        test.addModel(1);
        test.addModel(2);
        test.addModel(3);
    }

    @Test
    public void whenIndexTwo() {
        assertThat(test.getModel(2), is(3));
    }

    @Test
    public void whenDeleteSecondElement() {
        test.deleteModel(1);
        assertThat(test.getModel(1), is(3));
    }

    @Test
    public void whenSetSecondElement() {
        test.setModel(1, 5);
        assertThat(test.getModel(1), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        assertThat(test.iterator().hasNext(), is(true));
        assertThat(test.iterator().next(), is(1));
        assertThat(test.iterator().hasNext(), is(true));
        assertThat(test.iterator().next(), is(2));
        assertThat(test.iterator().hasNext(), is(true));
        assertThat(test.iterator().next(), is(3));
        assertThat(test.iterator().hasNext(), is(false));
        test.iterator().next();
    }
}
