package com.vijay.learn.spring5struts2.action;
/*
Project : spring5-struts2-integration
User    : Vijay Gupta
Date    : May 2020
*/

import com.opensymphony.xwork2.ModelDriven;
import com.vijay.learn.spring5struts2.domain.User;
import com.vijay.learn.spring5struts2.exception.UserAlreadyExistsException;
import com.vijay.learn.spring5struts2.exception.UserNotFoundException;
import com.vijay.learn.spring5struts2.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

@Component
@Scope(value = "prototype")
@Namespace("/user")
public class UserAction implements ModelDriven {

    Long id;
    String message;
    private final UserService userService;

    User user = new User();
    private List<User> listOfUsers = new ArrayList<>();

    public UserAction(UserService userService) {
        this.userService = userService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    @Action(value = "showRegistrationPage", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/views/register.jsp")
    })
    public String showRegistrationPage() {
        //showRegistrationScreen();
        return SUCCESS;
    }

    @Action(value = "registerUser", results = {
            @Result(name = SUCCESS,type = "chain",  location = "getAllUsers.action"),
            @Result(name= ERROR, location="/WEB-INF/views/register.jsp")
    }, exceptionMappings = {
            @ExceptionMapping(exception = "com.vijay.learn.spring5struts2.exception.UserAlreadyExistsException", result = SUCCESS,params = {"error", "User Already Registered"})
    })
    public String registerUser() throws UserAlreadyExistsException {
        System.out.println("UserAction.saveUser - user = " + user.toString());

        user = this.userService.registerUser(user);

        if(!StringUtils.isEmpty(user)) {
            message = "Registration Successful";
            return SUCCESS;
        }else {
            message = "Unable to Register";
            return ERROR;
        }
    }

    @Action(value = "update", results = {
            @Result(name = SUCCESS,type = "chain",  location = "getAllUsers.action")
    })
    public String update() {
        User user = this.userService.findUserById(id);
        if(!StringUtils.isEmpty(user)) {
            message = "Update User Details Below";
            return SUCCESS;
        }else {
            message = "Unable to retrive User";
            return ERROR;
        }
    }

    @Action(value = "getAllUsers", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/views/home.jsp")
    })
    public String getAllUsers() {
        listOfUsers = this.userService.getAllUsers();
        if(!StringUtils.isEmpty(listOfUsers)) {
            message = "User List Retrived";
            return SUCCESS;
        }else {
            message = "Unable to fetch Users";
            return ERROR;
        }
    }

    @Action(value = "delete", results = {
            @Result(name = SUCCESS,type = "chain",  location = "getAllUsers.action")
    }, exceptionMappings = {
            @ExceptionMapping(exception = "com.vijay.learn.spring5struts2.exception.UserNotFoundException", result = SUCCESS,params = {"error", "UserNotFoundException"})
    })
    public String delete() throws UserNotFoundException {
        this.userService.delete(id);
        return SUCCESS;// redirect the url
    }

    @Action(value = "updateUser", results = {
            @Result(name = SUCCESS,type = "chain",  location = "getAllUsers.action")
    }, exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = SUCCESS,params = {"error", "Exception - Vijay"})
    })
    public String updateUser() throws Exception {
        System.out.println("UserAction.updateUser - user = " + user.toString());
        /*if (bindingResult.hasErrors()) {
            System.err.println("UserWebController.updateUser -  bindingResult = " + bindingResult.getAllErrors().toString());
            //showRegistrationScreen();
            return "update";
        }*/
        this.userService.updateUser(user);
        return SUCCESS;// redirect the url
    }

   /* //This method will be called before any of Action method is invoked;
    //So some pre-processing if required.
    @Override
    public void prepare() throws Exception {

    }*/

    @Override
    public Object getModel() {
        return user;
    }
}
