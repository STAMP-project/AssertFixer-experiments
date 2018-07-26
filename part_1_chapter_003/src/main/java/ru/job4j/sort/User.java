package ru.job4j.sort;

import java.util.Comparator;

public class User implements Comparable<User> {

     public int age;
     public String name;

     User(String name, int age) {
         this.age = age;
         this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }
}

