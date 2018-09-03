package ru.job4j.additional;

import java.util.concurrent.*;

public class SemDemo {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new IncThread(sem, "A");
        new DecThread(sem, "B");
    }
}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Starting thread " + name);
        try {
            System.out.println("Thread " + name + " is waiting for permission");
            sem.acquire();
            System.out.println("Thread " + name + " got permission");
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + " " + Shared.count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + name + " gave back permission");
        sem.release();
    }
}

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Starting thread " + name);
        try {
            System.out.println("Thread " + name + " is waiting for permission");
            sem.acquire();
            System.out.println("Thread " + name + " got permission");
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + " " + Shared.count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + name + " gave back permission");
        sem.release();
    }
}