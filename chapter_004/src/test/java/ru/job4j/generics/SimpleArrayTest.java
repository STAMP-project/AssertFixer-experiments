package ru.job4j.generics;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    SimpleArray<String> arr = new SimpleArray<String>(2);


    @Test
    public void whenAddThenAdd() {
        arr.add("String1");
        assertThat(arr.get(0), is("String1"));
    }

    @Test
    public void whenSetThenSet() {
        arr.set(0, "ModifiedString");
        assertThat(arr.get(0), is("ModifiedString"));
    }

    @Test
    public void whenSeleteThenNull() {
        arr.delete(0);
        assertNull(arr.get(0));
    }

}