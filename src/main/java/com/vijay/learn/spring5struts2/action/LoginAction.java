package com.vijay.learn.spring5struts2.action;
/*
Project : spring5-struts2-integration
User    : Vijay Gupta
Date    : May 2020
*/

import com.opensymphony.xwork2.ModelDriven;
import com.vijay.learn.spring5struts2.domain.Login;
import com.vijay.learn.spring5struts2.service.LoginService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

@Component
@Scope(value = "prototype")
@Namespace("/login")
public class LoginAction implements ModelDriven {
    String message;
    private final LoginService loginService;

    Login login = new Login();

    public LoginAction(LoginService loginService) {
        this.loginService = loginService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Action(value = "showLoginPage", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/views/login.jsp")
    })
    public String showLoginPage() {
        //showLoginScreen();
        return SUCCESS;
    }

    @Action(value = "login", results = {
            @Result(name = SUCCESS,type = "chain", location = "getAllUsers.action"),
            @Result(name= ERROR, location="/WEB-INF/views/login.jsp")
    }, exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = ERROR,params = {"error", "Exception"})
    })
    public String login() throws Exception {
        System.out.println("LoginController.login - login = " + login.toString());

        Login loginUser = this.loginService.login(login);
        if(!StringUtils.isEmpty(loginUser)) {
            message = "Welcome "+loginUser.getUsername();
            return SUCCESS;
        }else {
            message = "Error in Login";
            return ERROR;
        }
    }

   /* //This method will be called before any of Action method is invoked;
    //So some pre-processing if required.
    @Override
    public void prepare() throws Exception {

    }*/

    @Override
    public Object getModel() {
        return login ;
    }

   /* public String login() throws Exception {
        return "success";
    }*/
}
