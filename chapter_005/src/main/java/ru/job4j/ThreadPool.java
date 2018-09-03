package ru.job4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    private final List<Thread> threads = new LinkedList<>();
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    int size = Runtime.getRuntime().availableProcessors();

    private void initLoad() {
        for (int i = 0; i < size; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    while (tasks.isEmpty()) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    tasks.poll().run();
                }
            };
            thread.run();
            threads.add(thread);
        }
    }

    public ThreadPool() {
        this.initLoad();
    }

    public void work(Runnable job) {
            tasks.offer(job);
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}