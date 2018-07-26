package ru.job4j.bank;

public class User {

    private String name;
    private int passport;

    User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return this.name;
    }

    public int getPassport() {
        return this.passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }
}
