package ru.job4j.troubles;

import java.util.concurrent.Semaphore;

public class WrongMath {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new Increment(sem);
        new Decrement(sem);
    }
}

class Common {
    static int counter = 5;
}

class Increment implements Runnable {
    Semaphore semaphore;

    Increment(Semaphore semaphore) {
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (int i = 0; i < 5; i++) {
                Common.counter++;
                Thread.sleep(100);
                System.out.println("Increment " + Common.counter);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}

class Decrement implements Runnable {
    Semaphore semaphore;

    Decrement(Semaphore semaphore) {
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (int i = 0; i < 5; i++) {
                Common.counter--;
                Thread.sleep(1000);
                System.out.println("Decrement " + Common.counter);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}

