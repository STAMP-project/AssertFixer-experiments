package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {


    @Test
    public void whenAddOneObjectThenAdded() {
        List<String> list = new ArrayList<>();
        list.add("test");
        assertThat(list.get(0), is("test"));
    }

    @Test
    public void whenAddManyObjectThenObjectsAddedAndListGrows() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add("test");
        }

        assertThat(list.get(199), is("test"));
    }

    @Test
    public void whenSetCapacityAndChangeCapacityThenEnlarge() {
        List<String> list = new ArrayList<>(2);

        list.add("test1");
        list.add("test2");
        assertTrue(list.iterator().hasNext());
        list.iterator().next();
        list.add("test3");
        list.add("test4");
        assertTrue(list.iterator().hasNext());
        list.iterator().next();
        assertTrue(list.iterator().hasNext());

    }

}