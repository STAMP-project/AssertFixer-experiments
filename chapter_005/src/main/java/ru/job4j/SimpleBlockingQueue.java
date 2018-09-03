package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    final protected Queue<T> storage = new LinkedList<>();
    final private Object lockToAdd = new Object();
    final private Object lockToPoll = new Object();
    private final int capacity;
    private int size = 0;
    private boolean blockSwitch = false; //allow to add when false

    public SimpleBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public boolean offer(T value) throws InterruptedException {
        boolean result;
        synchronized (this.lockToAdd) {
        switcher();
            while (blockSwitch) { // check the executing logic
                switcher();
                lockToAdd.wait();
            }
            result = add(value);
            try {
                lockToPoll.notify();
            } catch (IllegalMonitorStateException imse) {
                imse.printStackTrace();
                System.out.println("Thread was active");
            }
        }
        return result;
    }

    void switcher() {
        synchronized (this.lockToAdd) {
            if (this.size < this.capacity) {
                blockSwitch = false; //Allow to add
            } else {
                blockSwitch = true;
            }
        }
    }

    public T poll() throws InterruptedException {
        T result = null; //is it correct to initialize variable here?
        synchronized (this.lockToPoll) {
            while (storage.isEmpty()) {
               lockToAdd.wait();
            }
            result = pollStorage();
            try {
                lockToAdd.notifyAll();
            } catch (IllegalMonitorStateException imse) {
                imse.printStackTrace();
                System.out.println("Thread was active");
            }
        }
        return result;
    }

    private synchronized boolean add(T value) {
        boolean result;
        result = storage.offer(value);
        size++;
        return result;
    }
    private synchronized T pollStorage() {
        T result;
        result = storage.poll();
        size--;
        return result;
    }
}
