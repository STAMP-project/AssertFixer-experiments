package com.cjyong.pcw.cp.main.controller;

import com.cjyong.pcw.cp.conf.ApiInfo;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/5
 * Time: 15:36
 * Description: User interface class.
 */
@RestController
@RequestMapping(ApiInfo.userApi)
@Api("用户操作API")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "用户登录获取token")
    @PostMapping(ApiInfo.login)
    public MyJsonResult login(@RequestParam String account, @RequestParam String password) throws Exception{
        return userService.login(account,password);
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping(ApiInfo.updateUserInfo)
    public MyJsonResult update(@RequestParam Long id,
                               @RequestParam String password,
                               @RequestParam String account,
                               @RequestParam String name,
                               @RequestParam String tel,
                               @RequestParam String email,
                               @RequestParam String address,
                               @RequestParam String qq) throws Exception{
        return userService.updateUserInfo(id, password, account, name, tel, email, address, qq);
    }
}
