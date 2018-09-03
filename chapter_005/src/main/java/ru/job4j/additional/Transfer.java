package ru.job4j.additional;

import java.util.concurrent.Callable;

public class Transfer implements Callable<Boolean> {
    int amount;
    Account account1 = new Account(amount);
    Account account2 = new Account(amount);

    public Transfer(Account account1, Account account2, int amount) {
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        boolean result = false;
        if (account1.getBalance() < amount) {
            throw new ArithmeticException("Not enough money");
        }
        if (account1.getLock().tryLock()) {
            try {
                if (account2.getLock().tryLock()) {
                    try {
                        account1.withdraw(amount);
                        account2.deposit(amount);
                        return true;
                    } finally {
                        account1.getLock().unlock();
                    }
                }
            } finally {
                account1.getLock().unlock();
            }
        } else {
            account1.isFailedTransferCount();
            return false;
        }
        System.out.println(amount + " from " + account1
                + " to " + account2);
        return result;
    }
}
