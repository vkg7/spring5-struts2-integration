package com.vijay.learn.spring5struts2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Project : spring-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

@ResponseStatus(value= HttpStatus.CONFLICT, reason="User Already Exists") //404
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
