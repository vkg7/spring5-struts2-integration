package com.vijay.learn.spring5struts2.repository;
/*
Project : spring5-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring5struts2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "update user u set u.user_name = :userName, u.user_role = :userRole, u.user_status = :userStatus where u.id = :id", nativeQuery = true)
    void updateUser(@Param("userName") String userName,@Param("userRole") String userRole,@Param("userStatus") String userStatus,@Param("id") Long id);
}
