package com.kikux.curso.springboot.error.springboot_error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kikux.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.kikux.curso.springboot.error.springboot_error.models.domain.User;
import com.kikux.curso.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    UserService userService;

    @GetMapping
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    // public ResponseEntity<?> show(@PathVariable(name="id") Long id) {
    public User show(@PathVariable(name="id") Long id) {
        //OPTION1 
        // User user = userServiceImpl.findById(id);
        // if (user == null) {
        //     throw new UserNotFoundException("Error el usuario no existe!");
        // }
        // return userServiceImpl.findById(id);

        //OPTION 2
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe!"));
        return user;

        //OPTION 3
        // Optional<User> userOptional = userService.findById(id);

        // if(userOptional.isEmpty()) {
        //     return ResponseEntity.notFound().build();
        //     //this is not caught by HandlerExceptioncontroller due to this is not an exception
        // }
        // return ResponseEntity.ok(userOptional.get());
    }

}
