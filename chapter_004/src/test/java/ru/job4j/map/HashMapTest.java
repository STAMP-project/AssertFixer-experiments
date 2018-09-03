package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashMapTest {
    @Test
    public void whenAddNewElementThenAdded() {
        Map<Integer, String> map = new HashMap<>();
        assertTrue(map.insert(2222, "first"));
        assertTrue(map.insert(33333, "second"));
    }

    @Test
    public void whenAddNewElementThenNotAdded() {
        Map<Integer, String> map = new HashMap<>();
        assertTrue(map.insert(2222, "first"));
        assertFalse(map.insert(2222, "second"));
    }

    @Test
    public void whenGetElementThenGot() {
        Map<Integer, String> map = new HashMap<>();
        map.insert(2222, "first");
        assertThat(map.get(2222), is("first"));
    }

    @Test
    public void whenDeleteElementThenTrue() {
        Map<Integer, String> map = new HashMap<>();
        map.insert(2222, "first");
        assertTrue(map.delete(2222));
    }

}