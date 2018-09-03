package ru.job4j.usersort;

public class User implements Comparable<User> {
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}