package ru.job4j.bank;

import java.util.*;

/**
 * Класс Bank, для проведения операций с аккаунтами.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Bank {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод addUser добавляет пользователя.
     *
     * @param user пользователь.
     */
    public void addUser(User user) {
        this.users.put(user, new ArrayList<>());
    }

    public List<User> findAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (Map.Entry<User, List<Account>> user : this.users.entrySet()) {
            users.add(user.getKey());
        }
        return users;
    }

    /**
     * Метод удаляет пользователя.
     *
     * @param user пользователь
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Метод добавляет пользователю счёт.
     *
     * @param passport номер паспорта пользователя.
     * @param account  счёт пользователя.
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> user : this.users.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                this.users.get(user.getKey()).add(account);
            }
        }
    }

    /**
     * Метод deleteAccountFromUser удаляет счёт из списка счетов пользователя.
     *
     * @param passport номер паспорта пользователя.
     * @param account  счёт пользователя.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> user : this.users.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                this.users.get(user.getKey()).remove(account);
            }
        }
    }

    /**
     * Метод getUserAccounts возвращает список счетов пользователя.
     *
     * @param passport номер паспорта пользователя.
     * @return список счетов пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> user : this.users.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                accounts = this.users.get(user.getKey());
            }
        }
        return accounts;
    }

    /**
     * Метод getActualAccount для получения актуальности счёта.
     *
     * @param user    пользователь.
     * @param account его счёт.
     * @return актуальный счёт.
     */
    public Account getActualAccount(User user, Account account) {
        Account account1 = null;
        List<Account> list = this.users.get(user);
        if (list.indexOf(account) != -1) {
            account1 = list.get(list.indexOf(account));
        }
        return account1;
    }

    /**
     * Метод transferMoney, для перевода денег между счетами двух пользователей.
     *
     * @param srcPassport  номер паспорта отправителя.
     * @param srcAccount   счёт отправителя.
     * @param destPassport номер паспорта получателя.
     * @param dstAccount   счёт получателя.
     * @param amount       сумма средств.
     * @return исход операции.
     */
    public boolean transferMoney(String srcPassport, Account srcAccount, String destPassport, Account dstAccount, double amount) {
        User srcUser = null;
        User destUser = null;
        for (Map.Entry<User, List<Account>> user : this.users.entrySet()) {
            if (user.getKey().getPassport().equals(srcPassport)) {
                srcUser = user.getKey();
            } else if (user.getKey().getPassport().equals(destPassport)) {
                destUser = user.getKey();
            }
        }
        return this.users.get(srcUser).contains(srcAccount)
                && this.users.get(destUser).contains(dstAccount)
                && getActualAccount(srcUser, srcAccount).transferOfOwnFunds(getActualAccount(destUser, dstAccount), amount);
    }
}
