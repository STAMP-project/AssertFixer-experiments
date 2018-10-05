package ru.job4j.bank;

import java.util.*;

/**
 * Account.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Account {
    private double value;
    private String requisites;

    Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    double getValue() {
        return value;
    }

    String getRequisites() {
        return requisites;
    }

    /**
     * Метод transferOfOwnFunds для перевода денег среди своих счетов.
     *
     * @param destAccount аккаунт-назначение.
     * @param amount      сумма.
     * @return исход операции.
     */
    public boolean transferOfOwnFunds(Account destAccount, double amount) {
        boolean result = false;
        if ((destAccount != null) && (amount < this.value) && (amount > 0)) {
            result = true;
            this.value -= amount;
            destAccount.value += amount;
        }
        return result;
    }
}
