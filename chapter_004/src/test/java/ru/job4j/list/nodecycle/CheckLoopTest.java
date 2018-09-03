package ru.job4j.list.nodecycle;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CheckLoopTest {
    @Test(timeout = 1000)
    public void whenHasLoopThenTrue() {
        CheckLoop loop = new CheckLoop();
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(loop.hasCycle(first));
    }

}