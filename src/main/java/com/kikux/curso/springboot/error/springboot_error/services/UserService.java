package com.kikux.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.kikux.curso.springboot.error.springboot_error.models.domain.User;

public interface UserService {

    Optional<User> findById(Long id);
    List<User> findAll();
}
