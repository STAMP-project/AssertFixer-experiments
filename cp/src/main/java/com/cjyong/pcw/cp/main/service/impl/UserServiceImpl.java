package com.cjyong.pcw.cp.main.service.impl;

import com.cjyong.pcw.cp.conf.ApplicationInfo;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.dao.UserRepository;
import com.cjyong.pcw.cp.main.entity.User;
import com.cjyong.pcw.cp.main.entity.dto.UserWithToken;
import com.cjyong.pcw.cp.main.exception.ParameterInValidException;
import com.cjyong.pcw.cp.main.exception.PermissionInSufficientException;
import com.cjyong.pcw.cp.main.service.UserService;
import com.cjyong.pcw.cp.util.PCUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/28
 * Time: 17:38
 * Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyJsonResult login(String account, String passwd) throws Exception{
        if (PCUtils.hasEmpty(account, passwd)) {
            log.warn("用户登录异常" + "(" + account + "," + passwd + ")");
            throw new ParameterInValidException("userLogin(" + account + "," + passwd + "):NULL VALUE");
        }
        User user = userRepository.findUserByAccountAndPassword(account, passwd);
        if (user == null) {
            log.warn("用户登录异常" + "(" + account + "," + passwd + ")");
            throw new ParameterInValidException("userLogin(" + account + "," + passwd + "):USER NOT EXIST");
        }
        User user2 = userRepository.findFirstByIdNot(user.getId());

        //获取JWTToken
        String token= PCUtils.createJWT(ApplicationInfo.getJwtLife(), ApplicationInfo.getJwtKey());

        return new MyJsonResult(new UserWithToken(token, user, user2));
    }

    public MyJsonResult updateUserInfo(Long id, String password, String account, String name, String tel, String email,
                                String address, String qq) throws Exception{
        PCUtils.checkUserId(id, "updateUserInfo");
        User user = userRepository.findById(id).orElse(null);
        //进行权限校验
        if (user == null || !user.getPassword().equals(password)) {
            log.warn("用户修改异常" + "(" + id + "," + account + "," + password + ")");
            throw new PermissionInSufficientException("userUpdate(" + id + "," + account + "," + password + "):" +
                    "用户权限不足");
        }
        user.setPassword(password)
                .setAccount(account)
                .setName(name)
                .setTel(tel)
                .setEmail(email)
                .setAddress(address)
                .setQq(qq);
        User result = userRepository.saveAndFlush(user);
        ApplicationInfo.setUser(result);
        return new MyJsonResult(result);
    }
}
