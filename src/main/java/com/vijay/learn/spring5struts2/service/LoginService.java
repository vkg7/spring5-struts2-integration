package com.vijay.learn.spring5struts2.service;
/*
Project : spring-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring5struts2.domain.Login;

public interface LoginService {
    Login login(Login login) throws Exception;
}
