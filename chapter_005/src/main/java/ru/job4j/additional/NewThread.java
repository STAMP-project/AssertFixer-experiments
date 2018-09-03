package ru.job4j.additional;

public class NewThread implements Runnable {
    String name;
    Thread t;
    boolean suspendedFlag;

    NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendedFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendedFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + "interrupted");
        }
        System.out.println(name + " completed");
    }

    synchronized void suspend() {
        suspendedFlag = true;
    }

    synchronized void resume() {
        suspendedFlag = false;
        notify();

    }
}

class SuspendResume {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        try {
            Thread.sleep(1000);
            ob1.suspend();
            System.out.println("Thread one paused");
            Thread.sleep(1000);
            ob1.resume();
            System.out.println("Thread one resumed");
            ob2.suspend();
            System.out.println("Thread two paused");
            Thread.sleep(1000);
            ob2.resume();
            System.out.println("Thread two resumed");
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }
        try {
            System.out.println("Waiting for completing threads...");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }
        System.out.println("main thread is completed");
    }

}