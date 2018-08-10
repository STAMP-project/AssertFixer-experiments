package ru.job4j.sort;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Класс пользователь.
 */
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

