package com.kikux.curso.springboot.error.springboot_error.services;

import java.util.List;

import com.kikux.curso.springboot.error.springboot_error.models.domain.User;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
}
