package com.yigityilmaz.lab1webapplication.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/{name}")
    public String helloUser(@PathVariable String name) {
        return "Hello " + name;
    }
}
