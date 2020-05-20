package com.vijay.learn.spring5struts2.exception;

import com.vijay.learn.spring5struts2.domain.Login;
import com.vijay.learn.spring5struts2.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/*
Project : spring-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundException(HttpServletRequest request, Exception ex, HandlerMethod handlerMethod){
        System.err.println("Requested URL="+request.getRequestURL());
        System.err.println("Exception Raised="+ex);
        System.err.println("handlerMethod = "+handlerMethod);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("handlerMethod", handlerMethod);
        modelAndView.addObject("login",new Login());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ModelAndView handlePasswordMismatchException(HttpServletRequest request, Exception ex, HandlerMethod handlerMethod){
        System.err.println("Requested URL="+request.getRequestURL());
        System.err.println("Exception Raised="+ex);
        System.err.println("handlerMethod = "+handlerMethod);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("handlerMethod", handlerMethod);
        modelAndView.addObject("login",new Login());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ModelAndView handleUserAlreadyExistsException(HttpServletRequest request, Exception ex, HandlerMethod handlerMethod){
        System.err.println("Requested URL="+request.getRequestURL());
        System.err.println("Exception Raised="+ex);
        System.err.println("handlerMethod = "+handlerMethod);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("handlerMethod", handlerMethod);
        modelAndView.addObject("user",new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @ExceptionHandler(SQLException.class)
    public ModelAndView handleSQLException(HttpServletRequest request, Exception ex){
        logger.info("SQLException Occured:: URL="+request.getRequestURL());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.setViewName("database_error");
        return modelAndView;
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="IOException occured")
    @ExceptionHandler(IOException.class)
    public void handleIOException(){
        System.err.println("IOException handler executed");
        //returning 404 error code
    }
}
