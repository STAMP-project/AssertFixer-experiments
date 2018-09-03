package ru.job4j.additional;

import javax.naming.InsufficientResourcesException;

public class Operations {
    public static void main(String[] args) {
        final Account a = new Account(1000);
        final Account b = new Account(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                transfer(a, b, 500);
            }
        }).start();
        transfer(b, a, 300);
    }

    /* always deadlock*/
/*
    static void transfer(Account acc1, Account acc2, int amount) throws ArithmeticException{
        if (acc1.getBalance() < amount) {
            throw new ArithmeticException("Not enough money");
        }
        synchronized (acc1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (acc2) {
                acc1.withdraw(amount);
                acc2.deposit(amount);
            }
        }
        System.out.println(amount + " from " + acc1
                + " to " + acc2);
    }

    */
    static void transfer(Account acc1, Account acc2, int amount) throws ArithmeticException {
        if (acc1.getBalance() < amount) {
            throw new ArithmeticException("Not enough money");
        }
        if (acc1.getLock().tryLock()) {
            try {
                if (acc2.getLock().tryLock()) {
                    try {
                        acc1.withdraw(amount);
                        acc2.deposit(amount);
                    } finally {
                        acc1.getLock().unlock();
                    }
                }
            } finally {
                acc1.getLock().unlock();
            }
        } else {
            acc1.isFailedTransferCount();
        }
        System.out.println(amount + " from " + acc1
                + " to " + acc2);
    }

}
