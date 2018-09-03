package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedSetTest {
    @Test
    public void whenAddSomeElementsThenAdded() {
        LinkedSet<Integer> set = new LinkedSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertFalse(set.add(2));
    }
}