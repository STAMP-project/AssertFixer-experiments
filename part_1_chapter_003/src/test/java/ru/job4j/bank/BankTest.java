package ru.job4j.bank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    public String l = System.lineSeparator();

    @Before
    public void inputdata() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenAddUser() {
        Bank test = new Bank();
        test.addUser("Victor", 7525);
        test.listUsers();
        assertThat(new String(this.out.toByteArray()), is("Victor 7525" + l + "№ 0 - 0,00 руб." + l));
    }

    @Test
    public void whenAddMoneyToAccountUser() {
        Bank test = new Bank();
        test.addUser("Victor", 7525);
        test.addMoneyToAccountUser(7525, 0, 13000);
        test.listUsers();
        assertThat(new String(this.out.toByteArray()), is("Victor 7525" + l + "№ 0 - 13000,00 руб." + l));
    }

    @Test
    public void whenDeleteUser() {
        Bank test = new Bank();
        test.addUser("Victor", 7525);
        test.deleteUser(7525);
        test.listUsers();
        assertThat(new String(this.out.toByteArray()), is(""));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank test = new Bank();
        test.addUser("Victor", 7525);
        test.addAccountToUser(7525);
        test.listUsers();
        assertThat(new String(this.out.toByteArray()), is("Victor 7525" + l + "№ 0 - 0,00 руб." + l + "№ 1 - 0,00 руб." + l));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        Bank test = new Bank();
        test.addUser("Victor", 7525);
        test.addAccountToUser(7525);
        test.deleteAccountFromUser(7525, 0);
        test.listUsers();
        assertThat(new String(this.out.toByteArray()), is("Victor 7525" + l + "№ 1 - 0,00 руб." + l));
    }
/*
    @Test
    public void whenTransferMoney() {
        Bank test = new Bank();
        test.addUser("Ann", 7525);
        test.addMoneyToAccountUser(7525, 0, 1000);
        test.addUser("Annno", 7545);
        test.transferMoney(7525, 0, 7545, 1, 500);
        test.listUsers();
        assertThat(new String(this.out.toByteArray()), is("Ann 7525" + l + "№ 0 - 500,00 руб." + l + "Annno 7545" + l + "№ 1 - 500,00 руб." + l));
    }
*/
    @Test
    public void whenTransferMoneyOneUser() {
        Bank test = new Bank();
        test.addUser("Ann", 7525);
        test.addMoneyToAccountUser(7525, 0, 1000);
        test.addAccountToUser(7525);
        test.transferMoney(7525, 0, 7525, 1, 500);
        test.listUsers();
        assertThat(new String(this.out.toByteArray()), is("Ann 7525" + l + "№ 0 - 500,00 руб." + l +  "№ 1 - 500,00 руб." + l));
    }
}

