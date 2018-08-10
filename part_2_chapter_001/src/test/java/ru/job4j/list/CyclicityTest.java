package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CyclicityTest {

    Cyclicity test = new Cyclicity();

    public static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    @Test
    public void whenHasCycle() {
        test.first.next = test.two;
        test.two.next = test.third;
        test.third.next = test.four;
        test.four.next = test.first;
        assertThat(test.hasCycle(test.first), is(true));
    }

    @Test
    public void whenHasCycleCentre() {
        test.first.next = test.two;
        test.two.next = test.third;
        test.third.next = test.two;
        test.four.next = null;
        assertThat(test.hasCycle(test.first), is(true));
    }

    @Test
    public void whenHasNotCycle() {
        test.first.next = test.two;
        test.two.next = test.third;
        test.third.next = test.four;
        test.four.next = null;
        assertThat(test.hasCycle(test.first), is(false));
    }
}
