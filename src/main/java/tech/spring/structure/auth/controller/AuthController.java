package tech.spring.structure.auth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.spring.structure.auth.model.User;

@RestController
public class AuthController {

    @RequestMapping("/user")
    public User user(@AuthenticationPrincipal User user) {
        return user;
    }

}
