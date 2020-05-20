package com.vijay.learn.spring5struts2.service;
/*
Project : spring5-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring5struts2.domain.User;
import com.vijay.learn.spring5struts2.exception.UserAlreadyExistsException;
import com.vijay.learn.spring5struts2.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User findUserById(Long id);

    User findUserByUserId(String userId);

    User registerUser(User user) throws UserAlreadyExistsException;

    void delete(Long id) throws UserNotFoundException;

    void updateUser(User user) throws UserNotFoundException;
}
