package com.kikux.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kikux.curso.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private List<User> users;

    // public UserServiceImpl() {
        // this.users = new ArrayList<>();
        // users.add(new User(1L, "Enrique", "Amador"));
        // users.add(new User(2L, "Juan", "Aristizabal"));
        // users.add(new User(3L, "David", "Fuentes"));
        // users.add(new User(4L, "Paco", "Perez"));
        // users.add(new User(5L, "Pepe", "Hernandez"));
    // }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(usr -> usr.getId().equals(id)).findFirst();
        // for (User user : users) {
        //     if(user.getId() == id) {
        //         u = user;
        //         break;
        //     }
        // }
        // return Optional.ofNullable(u);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

}
