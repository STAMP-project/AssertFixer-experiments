package ru.job4j;

import org.junit.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.Bank;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BankTest {

    @Test
    public void whenUserAddThenUserAdded() {
        Bank bank = new Bank();
        User testUser = new User();
        testUser.setPassport("4005 222548");
        testUser.setName("Ivan");
        bank.addUser(testUser);
        assertThat(bank.toString(), is("Bank{accounts={" + testUser + "=[]}}"));
    }

    @Test
    public void whenUserDeletedThenNull() {
        Bank bank = new Bank();
        User testUser = new User();
        testUser.setPassport("4005 222548");
        testUser.setName("Ivan");
        bank.addUser(testUser);
        System.out.println(bank.toString());
        bank.delete(testUser);
        assertThat(bank.toString(), is("Bank{accounts={}}"));
    }

    @Test
    public void whenAddAccountToUserThenAdded() {
        Bank bank = new Bank();
        User testUser = new User();
        testUser.setPassport("4005 222548");
        testUser.setName("Ivan");
        bank.addUser(testUser);
        Account account1 = new Account();
        account1.setValue(10000.01);
        account1.setRequisites("111");
        bank.addAccountToUser(testUser, account1);
        System.out.println(bank.toString());
        assertThat(bank.toString(), is("Bank{accounts={" + testUser + "=[" + account1 + "]}}"));
    }

    @Test
    public void whenAccountDeletedThenDelete() {
        Bank bank = new Bank();
        User testUser = new User();
        testUser.setPassport("4005 222548");
        testUser.setName("Ivan");
        bank.addUser(testUser);
        Account account1 = new Account();
        account1.setValue(10000.01);
        account1.setRequisites("111");
        bank.addAccountToUser(testUser, account1);
        System.out.println(bank.toString());
        bank.deleteAccountFromUser(testUser, account1);
        assertThat(bank.toString(), is("Bank{accounts={" + testUser + "=[]}}"));
    }

    @Test
    public void whenGetAccountsFromUserThenGetIt() {
        Bank bank = new Bank();
        User testUser = new User();
        testUser.setPassport("4005 222548");
        testUser.setName("Ivan");
        bank.addUser(testUser);
        Account account1 = new Account();
        account1.setValue(10000.01);
        account1.setRequisites("111");
        Account account2 = new Account();
        account2.setValue(10000.02);
        account2.setRequisites("222");

        bank.addAccountToUser(testUser, account1);
        bank.addAccountToUser(testUser, account2);
        System.out.println(bank.toString());
        List<Account> list = new ArrayList<>();
        list.add(account1);
        list.add(account2);
        assertThat(bank.getAccounts(testUser).toString(), is(list.toString()));
    }

    @Test
    public void whenTransferMoneyThenMoneyGone() {

        Bank bank = new Bank();
        User testUser1 = new User();
        testUser1.setPassport("4002 464686");
        testUser1.setName("Bob");

        User testUser2 = new User();
        testUser2.setPassport("4005 222548");
        testUser2.setName("Ivan");

        Account account1 = new Account();
        account1.setValue(10000.01);
        account1.setRequisites("111");

        Account account2 = new Account();
        account2.setValue(10000.02);
        account2.setRequisites("222");

        Account account3 = new Account();
        account3.setValue(10000.03);
        account3.setRequisites("333");

        bank.addUser(testUser1);
        bank.addUser(testUser2);
        bank.addAccountToUser(testUser1, account1);
        bank.addAccountToUser(testUser1, account2);
        bank.addAccountToUser(testUser2, account3);

        bank.transfer(testUser1.getPassport(), account1.getRequisites(),
                testUser2.getPassport(), account3.getRequisites(),
                1000);
        assertEquals(account3.getValue() - account1.getValue(), 2000, 1);

    }

    @Test
    public void whenTransferMoneyThenGetTrue() {

        Bank bank = new Bank();
        User testUser1 = new User();
        testUser1.setPassport("4002 464686");
        testUser1.setName("Bob");

        User testUser2 = new User();
        testUser2.setPassport("4005 222548");
        testUser2.setName("Ivan");

        Account account1 = new Account();
        account1.setValue(10000.01);
        account1.setRequisites("111");

        Account account2 = new Account();
        account2.setValue(10000.02);
        account2.setRequisites("222");

        Account account3 = new Account();
        account3.setValue(10000.03);
        account3.setRequisites("333");

        bank.addUser(testUser1);
        bank.addUser(testUser2);
        bank.addAccountToUser(testUser1, account1);
        bank.addAccountToUser(testUser1, account2);
        bank.addAccountToUser(testUser2, account3);

        boolean result = bank.transfer(testUser1.getPassport(), account1.getRequisites(),
                testUser2.getPassport(), account3.getRequisites(),
                1000);
        assertThat(result, is(true));

    }

    @Test
    public void whenTransferMoneyThenGetFalse() {

        Bank bank = new Bank();
        User testUser1 = new User();
        testUser1.setPassport("4002 464686");
        testUser1.setName("Bob");

        User testUser2 = new User();
        testUser2.setPassport("4005 222548");
        testUser2.setName("Ivan");

        Account account1 = new Account();
        account1.setValue(10000.01);
        account1.setRequisites("111");

        Account account2 = new Account();
        account2.setValue(10000.02);
        account2.setRequisites("222");

        Account account3 = new Account();
        account3.setValue(10000.03);
        account3.setRequisites("333");

        bank.addUser(testUser1);
        bank.addUser(testUser2);
        bank.addAccountToUser(testUser1, account1);
        bank.addAccountToUser(testUser1, account2);
        bank.addAccountToUser(testUser2, account3);

        boolean result = bank.transfer(testUser1.getPassport(), account1.getRequisites(),
                testUser2.getPassport(), account3.getRequisites(),
                100000);
        assertThat(result, is(false));

    }

}
