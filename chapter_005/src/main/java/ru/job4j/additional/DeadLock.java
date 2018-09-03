package ru.job4j.additional;

import java.util.concurrent.CountDownLatch;

public class DeadLock {
    private final CountDownLatch latch = new CountDownLatch(2);
    Object mutex1 = new Object();
    Object mutex2 = new Object();
    Thread thread1 = new Thread() {
        public void run() {
            synchronized (mutex1) {
                latch.countDown();
                try {
                    latch.await();
                    synchronized (mutex2) {
                        System.out.println("thread 1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    Thread thread2 = new Thread() {
        public void run() {
            synchronized (mutex2) {
                latch.countDown();
                try {
                    latch.await();
                    synchronized (mutex1) {
                        System.out.println("thread 2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String[] args) {
        DeadLock lock = new DeadLock();
        lock.thread1.start();
        lock.thread2.start();
    }
}
