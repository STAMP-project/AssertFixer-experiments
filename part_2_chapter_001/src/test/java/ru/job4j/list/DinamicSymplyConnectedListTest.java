package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DinamicSymplyConnectedListTest {

    private DinamicSymplyConnectedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new DinamicSymplyConnectedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenHasNext() {
        assertThat(list.hasNext(), is(true));
        assertThat(list.hasNext(), is(true));
        assertThat(list.hasNext(), is(true));
        assertThat(list.hasNext(), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void whenNext() {
        assertThat(list.next(), is(3));
        assertThat(list.next(), is(2));
        assertThat(list.next(), is(1));
        list.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenHasNextModification() {
        assertThat(list.hasNext(), is(true));
        list.add(4);
        assertThat(list.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenNextModification() {
        list.next();
        list.add(4);
        list.next();
    }

}
