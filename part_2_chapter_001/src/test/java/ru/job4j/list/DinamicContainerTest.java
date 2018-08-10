package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DinamicContainerTest {

    DinamicContainer test = new DinamicContainer();
    Object testobj = new Object();
    Object testobj1 = new Object();
    Object testobj2 = new Object();

    @Before
    public void beforeTest() {
        test.add(testobj);
        test.add(testobj1);
        test.add(testobj2);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultThree() {
        assertThat(test.get(2), is(testobj2));
    }

    @Test
    public void whenHasNext() {
        assertThat(test.hasNext(), is(true));
        assertThat(test.hasNext(), is(true));
        assertThat(test.hasNext(), is(true));
        assertThat(test.hasNext(), is(false));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenNext() {
        assertThat(test.next(), is(testobj));
        assertThat(test.next(), is(testobj1));
        assertThat(test.next(), is(testobj2));
        test.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurentExeptionHasNext() {
        test.next();
        Object testobj3 = new Object();
        test.add(testobj3);
        test.hasNext();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurentExeptionNext() {
        test.next();
        Object testobj3 = new Object();
        test.add(testobj3);
        test.next();
    }
}
