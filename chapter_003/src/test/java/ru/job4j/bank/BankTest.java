package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;

/**
 * BankTest.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class BankTest {
    /**
     * Тестируем метод addUser (добавление пользователя).
     */
    @Test
    public void whenAddUserThenNewUserAppears() {
        User user1 = new User("Svetlana", "123");
        Bank sberbank = new Bank();
        sberbank.addUser(user1);
        assertThat(sberbank.findAllUsers().size(), is(1));
    }

    /**
     * Тестируем метод deleteUser (удаление пользователя).
     */
    @Test
    public void whenDeleteUserThenUserDisappear() {
        User user1 = new User("Svetlana", "123");
        User user2 = new User("Petr", "456");
        Bank sberbank = new Bank();
        sberbank.addUser(user1);
        sberbank.addUser(user2);
        sberbank.deleteUser(user1);
        assertThat(sberbank.findAllUsers().size(), is(1));
    }

    /**
     * Тест метода addAccountToUser (добавление пользователю счёта).
     */
    @Test
    public void whenAddAccountThenTwoAccounts() {
        User user1 = new User("Svetlana", "123");
        Bank sberbank = new Bank();
        Account account1 = new Account(5000, "456");
        sberbank.addUser(user1);
        sberbank.addAccountToUser("123", account1);
        assertThat(sberbank.getUserAccounts("123").get(0).getRequisites(), is("456"));
    }

    /**
     * Тест метода deleteUserAccounts (удаление счёта пользователя).
     */
    @Test
    public void whenDeleteAccountThenOneAccount() {
        User user1 = new User("Svetlana", "123");
        Account account1 = new Account(5000, "456");
        Account account2 = new Account(4000, "789");
        Bank sberbank = new Bank();
        sberbank.addUser(user1);
        sberbank.addAccountToUser("123", account1);
        sberbank.addAccountToUser("123", account2);
        sberbank.deleteAccountFromUser("123", account1);
        assertThat(sberbank.getUserAccounts("123").get(0).getRequisites(), is("789"));
    }

    /**
     * Проверка метода getActualAccount (актуальность счёта пользователя).
     */
    @Test
    public void whenThereIsNoAccountThenMinusOne() {
        User user1 = new User("Svetlana", "123");
        Account account1 = new Account(5000, "456");
        Bank sberbank = new Bank();
        sberbank.addUser(user1);
        sberbank.addAccountToUser("123", account1);
        assertThat(sberbank.getActualAccount(user1, account1), is(account1));
    }

    /**
     * Тест метода transferMoney (перевод денег со счёта одного пользователя на счёт другого пользователя).
     */
    @Test
    public void whenTransferMoneyThenMoneyIsTransfered() {
        User user1 = new User("Svetlana", "123");
        Account account1 = new Account(5000, "456");
        User user2 = new User("Petr", "321");
        Account account2 = new Account(4000, "654");
        Bank sberbank = new Bank();
        sberbank.addUser(user1);
        sberbank.addAccountToUser("123", account1);
        sberbank.addUser(user2);
        sberbank.addAccountToUser("321", account2);
        assertThat(sberbank.transferMoney("123", account1, "321", account2, 1000), is(true));
    }
}