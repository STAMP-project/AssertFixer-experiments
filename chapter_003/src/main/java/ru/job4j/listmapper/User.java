package ru.job4j.listmapper;

public class User {
    private static int count = 0;
    private int id;
    private String name, city;

    public User(String name, String city) {
        this.name = name;
        this.city = city;
        id = count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }
}
