package ru.job4j.additional;

import java.util.concurrent.*;

public class StringCollector {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new ThreadForOne(sem, "1", 1);
        new ThreadForOne(sem, "2", 2);
    }
}

class SharedString {
    static String string = "";

    static void addDigit(int a) {
        string = new StringBuffer().append(a).toString();
    }
}

class ThreadForOne implements Runnable {
    String name;
    Semaphore sem;
    int a;

    ThreadForOne(Semaphore s, String n, int a) {
        this.a = a;
        this.sem = s;
        this.name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Starting thread " + name);
        while (true) {
            try {
                System.out.println("Thread " + name + " is waiting for permission");
                sem.acquire();
                System.out.println("Thread " + name + " got permission");
                for (int i = 0; i < 10; i++) {
                    SharedString.addDigit(a);
                    System.out.println(name + " " + SharedString.string);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + name + " gave back permission");
            sem.release();
            Thread.yield();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}