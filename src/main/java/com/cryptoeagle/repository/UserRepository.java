package com.cryptoeagle.repository;

import com.cryptoeagle.entity.User;

import java.util.List;

public interface UserRepository {

    User saveAndUpdate(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    User getByName(String name);

    List<User> getAll();

}


