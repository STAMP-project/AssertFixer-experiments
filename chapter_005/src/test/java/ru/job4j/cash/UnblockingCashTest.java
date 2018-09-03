package ru.job4j.cash;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnblockingCashTest {
    @Test(expected = OptimisticException.class)
    public void whenModifyThenException() {
        UnblockingCash cash = new UnblockingCash();
        Base base = new Base(1);
        cash.add(base);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                base.updateVersion();
               cash.update(base);
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

    }
}