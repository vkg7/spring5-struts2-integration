package com.vijay.learn.spring5struts2.domain;
/*
Project : spring5-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import javax.validation.constraints.NotEmpty;

public class Login {
    @NotEmpty(message = "Please enter your user id.")
    //@Size(min = 5, max = 15, message = "Your user id must between 5 and 15 characters")
    private String username;

    @NotEmpty(message = "Please enter your password.")
    //@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
