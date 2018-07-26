package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {

    private HashMap<User, List<Account>> bank = new HashMap<>(16, 0.75f);
    private int amountAccounts = 0;

    public void addUser(String name, int passport) {
        bank.put(new User(name, passport), new ArrayList<Account>(10));
        addAccountToUser(passport);
    }

    public void deleteUser(int passport) {
        bank.remove(getUser(passport));
    }

    public void addAccountToUser(int passport) {
        bank.get(getUser(passport)).add(new Account(0, amountAccounts));
        amountAccounts++;
    }

    public void deleteAccountFromUser(int passport, int requisites) {
        for (Account account : bank.get(getUser(passport))) {
            if (account.getRequisites() == requisites) {
                bank.get(getUser(passport)).remove(account);
            }
        }
    }

    public void addMoneyToAccountUser(int passport, int requisites, int value) {
        getAccount(passport, requisites).setValue(getAccount(passport, requisites).getValue() + value);
    }

    public List<Account> getUserAccounts(int passport) {
        return bank.get(getUser(passport));
    }

    public boolean transferMoney(int srcPassport, int srcRequisite, int destPassport, int destRequisite, double amount) {
        boolean result = false;
        if (getAccount(srcPassport, srcRequisite).getValue() >= amount) {
            getAccount(srcPassport, srcRequisite).setValue(getAccount(srcPassport, srcRequisite).getValue() - amount);
            getAccount(destPassport, destRequisite).setValue(getAccount(destPassport, destRequisite).getValue() + amount);
            result = true;
        }
        return result;
    }

    private User getUser(int passport) {
        User result = new User("", passport);
        for (User user : bank.keySet()) {
            if (user.getPassport() == passport) {
                result = user;
            }
        }
        return result;
    }

    private Account getAccount(int passport, int requisites) {
        Account result = new Account(0, 0);
        for (Account account : getUserAccounts(passport)) {
            if (account.getRequisites() == requisites) {
                result = account;
            }
        }
        return result;
    }

    public void listUsers() {
        for (User user : bank.keySet()) {
            System.out.printf("%s %d%n", user.getName(), user.getPassport());
            for (Account account : getUserAccounts(user.getPassport())) {
                System.out.printf("%s %d - %#.2f %s%n", "№", account.getRequisites(), account.getValue(), "руб.");
            }
        }
    }
}
