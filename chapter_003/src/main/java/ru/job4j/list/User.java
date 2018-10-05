package ru.job4j.list;

class User {
    private Integer id;
    private String name;
    private String city;

    User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    Integer getId() {
        return id;
    }
    String getName() {
        return name;
    }
    String getCity() {
        return city;
    }
}