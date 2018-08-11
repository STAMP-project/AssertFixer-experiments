package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CyclicityTest {

    Cyclicity test = new Cyclicity();
    Node first = new Node(1);
    Node two = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);

    @Test
    public void whenHasCycle() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(test.hasCycle(first), is(true));
    }

    @Test
    public void whenHasCycleCentre() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = null;
        assertThat(test.hasCycle(first), is(true));
    }

    @Test
    public void whenHasNotCycle() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(test.hasCycle(first), is(false));
    }
}
