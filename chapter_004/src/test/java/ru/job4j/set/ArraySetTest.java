package ru.job4j.set;

import org.junit.Test;


import static org.junit.Assert.*;

public class ArraySetTest {
    @Test
    public void whenAddSomeElementsThenAdded() {
        ArraySet<Integer> set = new ArraySet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertFalse(set.add(2));
    }
}