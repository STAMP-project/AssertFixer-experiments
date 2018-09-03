package ru.job4j.bank;

public class User implements Comparable<User> {
    private String name, passport;

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return this.passport.compareTo(o.getPassport());
    }
}
