package ru.job4j;

import java.util.List;

public interface Store {

    void addUser(User user);

    void updateUser(
            int id, User user);

    void deleteUser(int id);

    User findById(int id);

    List<User> findAll();

}