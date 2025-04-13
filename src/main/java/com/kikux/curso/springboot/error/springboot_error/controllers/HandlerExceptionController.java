package com.kikux.curso.springboot.error.springboot_error.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.kikux.curso.springboot.error.springboot_error.models.Error;

@ControllerAdvice
//instead of being mapped to URL, it is to an exception
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error e = new Error();
        e.setDate(new Date());
        e.setError("Error division por cero");
        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // return ResponseEntity.internalServerError().body(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException ex) {
        Error e = new Error();
        e.setDate(new Date());
        e.setError("Api REST no encontrado");
        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.NOT_FOUND.value());
        // return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(e);
    }
}
