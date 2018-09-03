package ru.job4j;

import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private AtomicInteger id;
    private String name, login, password, email;
    private long createDate;

    public User(String login, String password, String name, String email) {
        this.setLogin(login);
        this.setName(name);
        this.setPassword(password);
        this.setEmail(email);
        this.createDate = System.currentTimeMillis();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(AtomicInteger atomicInteger) {
        this.id = atomicInteger;
    }

    public AtomicInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getCreateDate() {
        return createDate;
    }


}
