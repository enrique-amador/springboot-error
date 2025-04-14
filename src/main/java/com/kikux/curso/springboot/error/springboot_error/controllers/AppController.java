package com.kikux.curso.springboot.error.springboot_error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kikux.curso.springboot.error.springboot_error.models.domain.User;
import com.kikux.curso.springboot.error.springboot_error.services.UserServiceImpl;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name="id") Long id) {
        // UserServiceImpl user = new UserServiceImpl(); //DO NOT: here we depend on implementation
        User user = userServiceImpl.findById(id);
        System.out.println(user.getLastName());
        return userServiceImpl.findById(id);
    }

}
