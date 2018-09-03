package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void whenCreateListThenCreated() {
        List<String> list = new LinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        String result = list.get(2);
        assertThat(result, is("test3"));
    }

    @Test
    public void whenIteratorIterateListThenGoesToTheEnd() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.iterator().hasNext());
        assertThat(list.iterator().next(), is(1));
        assertTrue(list.iterator().hasNext());
        assertThat(list.iterator().next(), is(2));
        assertTrue(list.iterator().hasNext());
        assertThat(list.iterator().next(), is(3));
        assertFalse(list.iterator().hasNext());
    }
}