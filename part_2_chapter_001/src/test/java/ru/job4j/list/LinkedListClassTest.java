package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LinkedListClassTest {

    private LinkedListClass<Integer> list;

    @Before
    public void beforeTest() {
        list = new LinkedListClass<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        list.delete();
        assertThat(list.get(1), is(1));
    }
}
