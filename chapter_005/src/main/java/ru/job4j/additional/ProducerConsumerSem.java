package ru.job4j.additional;

import java.util.concurrent.Semaphore;

public class ProducerConsumerSem {
    int n;
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("got.." + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.n = n;
        System.out.println("sent.." + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    ProducerConsumerSem pc;

    Producer(ProducerConsumerSem pc) {
        this.pc = pc;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            pc.put(i);
        }
    }
}

class Consumer implements Runnable {
    ProducerConsumerSem pc;

    Consumer(ProducerConsumerSem pc) {
        this.pc = pc;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            pc.get();
        }
    }
}

class ProdCon {
    public static void main(String[] args) {
        ProducerConsumerSem pc = new ProducerConsumerSem();
        new Consumer(pc);
        new Producer(pc);
    }
}