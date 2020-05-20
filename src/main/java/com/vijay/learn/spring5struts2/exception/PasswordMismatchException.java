package com.vijay.learn.spring5struts2.exception;
/*
Project : spring-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.EXPECTATION_FAILED, reason="User Name Or Password Does Not Match") //404
public class PasswordMismatchException extends Exception{
    public PasswordMismatchException(String message) {
        super(message);
    }
}
