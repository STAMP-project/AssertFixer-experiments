package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapSetTest {

    @Test
    public void whenAddSomeElementsThenAdded() {
        MapSet<Integer> set = new MapSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertFalse(set.add(2));
    }

    @Test
    public void whenRemoveSomeElementThenMethodWorks() {
        MapSet<Integer> set = new MapSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertFalse(set.remove(3));
        assertTrue(set.remove(2));
    }
    @Test
    public void whenSearchElementsThenContainsWorksProperly() {
        MapSet<Integer> set = new MapSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.contains(2));
        assertFalse(set.contains(3));
    }
    @Test
    public void whenArraysOverGrowThenNewArray() {
        MapSet<Integer> set = new MapSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        assertTrue(set.add(4));
    }
}