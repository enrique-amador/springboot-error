package com.kikux.curso.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kikux.curso.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Enrique", "Amador"));
        users.add(new User(2L, "Juan", "Aristizabal"));
        users.add(new User(3L, "David", "Fuentes"));
        users.add(new User(4L, "Paco", "Perez"));
        users.add(new User(5L, "Pepe", "Hernandez"));
    }

    @Override
    public User findById(Long id) {
        User u = null;
        for (User user : users) {
            if(user.getId() == id) {
                u = user;
                break;
            }
        }

        return u;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

}
