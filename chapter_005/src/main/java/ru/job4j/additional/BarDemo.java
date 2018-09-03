package ru.job4j.additional;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        System.out.println("preparing streams...");
        new DemoThread(cb, "A");
        new DemoThread(cb, "B");
        new DemoThread(cb, "C");
    }
}

class DemoThread implements Runnable {
    CyclicBarrier cyclicBarrier;
    String name;

    DemoThread(CyclicBarrier c, String n) {
        cyclicBarrier = c;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name + " running");

        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Barrier is going off");
        System.out.println("code after three other threads");
    }
}