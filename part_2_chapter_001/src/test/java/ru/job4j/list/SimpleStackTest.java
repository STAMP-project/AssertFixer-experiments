package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleStackTest {

    private SimpleStack<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleStack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
    }

    @Test
    public void whenPoll() {
        assertThat(list.poll(), is(4));
        assertThat(list.poll(), is(3));
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(1));
    }
}
