package ru.job4j.additional;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Running executing thread...");
        new CountDown(cdl);

        try {
            cdl.await(); // thread waits for in this point;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("It's the final countdown");
    }

    static class CountDown implements Runnable {
        CountDownLatch latch;

        CountDown(CountDownLatch cdl) {
            latch = cdl;
            new Thread(this).start();
        }

        @Override
        public void run() {
            for (int i = 3; i >= 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        }
    }
}
