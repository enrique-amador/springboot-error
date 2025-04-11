package com.kikux.curso.springboot.error.springboot_error.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//instead of being mapped to URL, it is to an exception
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<?> divisionByZero(Exception ex) {
        return ResponseEntity.internalServerError().body("error 500");
    }
}
