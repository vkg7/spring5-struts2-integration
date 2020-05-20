package com.vijay.learn.spring5struts2.domain;
/*
Project : spring5-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@Min(5)
    //@Max(15)
    @Column(name = "user_id")
    @NotEmpty(message = "User Id is required.")
    //@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
    private String userId;

    @Column(name = "user_name")
    @NotEmpty(message = "User name is required.")
    private String userName;

    @Column(name = "user_role",nullable = true)
    //@ColumnDefault("EMPLOYEE")
    private String userRole = "Employee";

    @Column(name = "user_status",nullable = true)
    //@ColumnDefault("ACTIVE")
    private String userStatus = "Active";

    @Column(name = "password")
    @NotEmpty(message = "Password is required")
    //@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
    private String password;

    @Column(name = "date",nullable = true)
    //@ColumnDefault(LocalDateTime.now())
    private LocalDateTime date = LocalDateTime.now();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return getId() != null ? getId().equals(user.getId()) : user.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userStatus='" + userStatus + '\'' +
                //", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
