package ru.job4j.additional;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    public AtomicInteger getFailCounter() {
        return failCounter;
    }

    private AtomicInteger failCounter = new AtomicInteger();

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    private Lock lock;
    private int balance;

    public Account(int balance) {
        this.lock = new ReentrantLock();
        this.balance = balance;
    }

    public void isFailedTransferCount() {
        failCounter.incrementAndGet();
    }

    public void withdraw(int ammount) {
        this.balance -= ammount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
}
