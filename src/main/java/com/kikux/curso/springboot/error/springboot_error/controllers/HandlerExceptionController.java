package com.kikux.curso.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.kikux.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.kikux.curso.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
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
    
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "numero incorrecto.");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }

    @ExceptionHandler({NullPointerException.class, 
        HttpMessageNotWritableException.class,
        UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "usuario no encontrado");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
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
