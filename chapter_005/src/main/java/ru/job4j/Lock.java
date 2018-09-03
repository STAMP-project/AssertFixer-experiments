package ru.job4j;


public class Lock {

    public void lock() {
        if (Thread.currentThread().isAlive()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            Thread.currentThread().start();
        }
    }

    public void unlock() {
        if (Thread.currentThread().equals(this)) {
            this.notify();
        }
    }
}