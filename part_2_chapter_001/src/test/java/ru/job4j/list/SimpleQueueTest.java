package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {

    private SimpleQueue<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleQueue<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
    }

    @Test
    public void whenPoll() {
        assertThat(list.poll(), is(1));
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(3));
        assertThat(list.poll(), is(4));
    }
}
