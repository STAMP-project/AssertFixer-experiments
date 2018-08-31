package ru.avvorotov.hw1.service;

import ru.avvorotov.hw1.model.User;

public interface UserService {

    User createUser(String firstName, String lastName);
}
