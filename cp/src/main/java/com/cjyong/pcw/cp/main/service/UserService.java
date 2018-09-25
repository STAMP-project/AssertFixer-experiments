package com.cjyong.pcw.cp.main.service;

import com.cjyong.pcw.cp.main.MyJsonResult;

public interface UserService {
    /**
     * 用户登陆， 登陆成功返回TokenJWT
     *
     * @param account
     * @param passwd
     * @return
     */
    MyJsonResult login(String account, String passwd) throws Exception;

    /**
     * 更新用户信息
     *
     * @param id
     * @param password
     * @param account
     * @param name
     * @param tel
     * @param email
     * @param address
     * @param qq
     * @return
     */
    MyJsonResult updateUserInfo(Long id, String password, String account, String name, String tel, String email,
                                String address, String qq) throws Exception;
}
