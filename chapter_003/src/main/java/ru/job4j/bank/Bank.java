package ru.job4j.bank;

import java.util.*;

public class Bank {

    private Map<User, ArrayList<Account>> treeMap = new TreeMap<>();

    public void addUser(User user) {
        this.treeMap.put(user, new ArrayList<>());
    }

    public void delete(User user) {
        this.treeMap.remove(user);
    }

    public void addAccountToUser(User user, Account account) {
        this.treeMap.get(user).add(account);
    }


    public void deleteAccountFromUser(User user, Account account) {
        this.treeMap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.treeMap.get(user);
    }

    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treeMap.get(user);
        return list.get(list.indexOf(account));
    }

    public boolean transfer(String srcPassport, String srcRequisite,
                            String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        User userSender = this.findByPassport(srcPassport);
        User userReceiver = this.findByPassport(destPassport);
        Account accountSender = this.findByRequisites(srcRequisite, treeMap.get(userSender));
        //Мы получили ссылку на аккаунт по двум методам, которые написали ниже
        Account accountReciever = this.findByRequisites(dstRequisite, treeMap.get(userReceiver));
        if (accountSender != null && accountReciever != null && accountSender.getValue() > amount) {
            accountSender.setValue(accountSender.getValue() - amount);
            accountReciever.setValue(accountReciever.getValue() + amount);
            result = true;
        }
        return result;
    }

    public User findByPassport(String srcPassport) {
        Set<User> userSet = treeMap.keySet(); // Мы найдем множество ключей, а там юзера, с паспортом из параметров
        User user1 = new User();
        for (User user : userSet
                ) {
            if (srcPassport.equals(user.getPassport())) {
                user1 = user; // это будет ключ для работы с картой
                break;
            }
        }
        return user1;
    }

    public Account findByRequisites(String srcRequisite, List<Account> list) {
        Account result = new Account();
        for (Account account : list
                ) {
            if (srcRequisite.equals(account.getRequisites())) {
                result = account;
                break;
            }
        }

        return result;
    }

    public String toString() {
        return "Bank{" + "accounts=" + treeMap + "}";
    }
}