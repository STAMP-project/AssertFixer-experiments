package com.bindstone.portfolio.factories;

import com.bindstone.portfolio.entity.User;

public class UserFactory {

    public static User USER_1() {
        return User.builder()
                .userId("USER_1")
                .password("PASSWORD_1")
                .build();
    }
}
