package com.vijay.learn.spring5struts2.service;
/*
Project : spring-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring5struts2.domain.Login;
import com.vijay.learn.spring5struts2.domain.User;
import com.vijay.learn.spring5struts2.exception.PasswordMismatchException;
import com.vijay.learn.spring5struts2.exception.UserNotFoundException;
import com.vijay.learn.spring5struts2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final UserRepository userRepository;
    private final UserService userService;

    public LoginServiceImpl(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public Login login(Login login) throws Exception {
        System.out.println("LoginServiceImpl.login - login = "+login.toString());
        User userByUserId = this.userService.findUserByUserId(login.getUsername());
        System.out.println("userByUserId.toString() - " + userByUserId.toString());
        if (!StringUtils.isEmpty(userByUserId)) {
            System.out.println("User present for this user id - " + login.getUsername());
            if (userByUserId.getPassword().equals(login.getPassword()))
                return login;
            else
                throw new PasswordMismatchException("User Name Or Password Does Not Match");
        } else {
            System.err.println("LoginServiceImpl.login - User Not Found For This User id - " + login.getUsername());
            throw new UserNotFoundException("User Not Found For This User id -  " + login.getUsername());
        }
    }
}
