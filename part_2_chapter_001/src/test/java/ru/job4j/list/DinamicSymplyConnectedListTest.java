package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DinamicSymplyConnectedListTest {

    private DinamicSymplyConnectedList list = new DinamicSymplyConnectedList<>();
    private ListIterator iterator = list.iterator();

    @Before
    public void beforeTest() {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
    }

    @Test
    public void whenHasNext() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void whenNext() {
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenHasNextModification() {
        assertThat(iterator.hasNext(), is(true));
        list.add(4);
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenNextModification() {
        iterator.next();
        list.add(4);
        iterator.next();
    }
}
