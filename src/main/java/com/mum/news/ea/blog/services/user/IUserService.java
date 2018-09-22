package com.mum.news.ea.blog.services.user;

import com.mum.news.ea.blog.models.User;

/**
 * User: franc
 * Date: 21/09/2018
 * Time: 11:50
 */


public interface IUserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}