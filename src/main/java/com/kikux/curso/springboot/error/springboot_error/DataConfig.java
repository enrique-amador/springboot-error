package com.kikux.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kikux.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class DataConfig {


    @Bean
    List<User> getUsersList() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Enrique", "Amador"));
        users.add(new User(2L, "Juan", "Aristizabal"));
        users.add(new User(3L, "David", "Fuentes"));
        users.add(new User(4L, "Paco", "Perez"));
        users.add(new User(5L, "Pepe", "Hernandez"));
        return users;
    }
}
