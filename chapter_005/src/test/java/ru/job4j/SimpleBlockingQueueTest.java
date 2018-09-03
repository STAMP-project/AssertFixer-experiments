package ru.job4j;

import org.junit.Test;


import java.util.Random;

import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

        SimpleBlockingQueue<Integer> mainTestQueue = new SimpleBlockingQueue(2);

    @Test
    public void whenElementsAddedThenAdded() throws InterruptedException {
        SimpleBlockingQueue<Integer> testQueue = new SimpleBlockingQueue(2);
        testQueue.offer(12);
        testQueue.offer(13);
        assertFalse(testQueue.storage.isEmpty());
    }

    @Test
    public void whenElementsAddedThenFailed() throws InterruptedException {
        SimpleBlockingQueue<Integer> testQueue = new SimpleBlockingQueue(2);
        testQueue.offer(12);
        testQueue.offer(13);
        assertFalse(testQueue.offer(14));
    }

    @Test
    public void whenAddExtraElementAfterDeleteParallel() throws InterruptedException {

        Thread adder = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainTestQueue.offer(new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread deleter = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainTestQueue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        adder.run();
        adder.join();
        adder.run();
        deleter.run();
        adder.run();
        deleter.run();

    }
}