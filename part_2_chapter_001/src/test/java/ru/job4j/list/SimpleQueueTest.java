package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import java.util.ListIterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {

    private SimpleQueue<Integer> list = new SimpleQueue<>();
    ListIterator iterator = list.iterator();

    @Before
    public void beforeTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void whenPoll() {
        assertThat(list.poll(), is(1));
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(3));
        assertThat(list.poll(), is(4));
    }

    @Test
    public void whenNext() {
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(1));
    }

    @Test
    public void whenHasNext() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(false));
    }
}
