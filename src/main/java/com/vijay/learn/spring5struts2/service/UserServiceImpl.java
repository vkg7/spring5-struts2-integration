package com.vijay.learn.spring5struts2.service;

import com.vijay.learn.spring5struts2.domain.User;
import com.vijay.learn.spring5struts2.exception.UserAlreadyExistsException;
import com.vijay.learn.spring5struts2.exception.UserNotFoundException;
import com.vijay.learn.spring5struts2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

/*
Project : spring5-mvc-maven
User    : Vijay Gupta
Date    : May 2020
*/

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> userResponse = this.userRepository.findById(id);
        if (userResponse.isPresent()) {
            return userResponse.get();
        } else {
            System.err.println("UserServiceImpl.findUserByUserId - User Not found with userId = " + id);
        }
        return null;
    }

    @Override
    public User findUserByUserId(String userId) {
        User probe = new User();
        probe.setUserId(userId);
        ExampleMatcher modelMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnorePaths("user_name")
                .withIgnorePaths("user_status")
                .withIgnorePaths("user_role")
                .withIgnorePaths("date")
                .withIgnorePaths("password")
                .withMatcher("user_id", ignoreCase());

        Example<User> example = Example.of(probe, modelMatcher);

        Optional<User> userResponse = this.userRepository.findOne(example);
        boolean ifUserExists = ifUserExists(userId);
        System.out.println("UserServiceImpl.findUserByUserId - ifUserExists = " + ifUserExists);
        if (userResponse.isPresent()) {
            return userResponse.get();
        } else {
            System.out.println("UserServiceImpl.findUserByUserId - User Not found with userId = " + userId);
        }
        return null;
    }

    private boolean ifUserExists(String userId) {
        User probe = new User();
        probe.setUserId(userId);
        ExampleMatcher modelMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnorePaths("user_name")
                .withIgnorePaths("user_status")
                .withIgnorePaths("user_role")
                .withIgnorePaths("date")
                .withIgnorePaths("password")
                .withMatcher("user_id", ignoreCase());

        Example<User> example = Example.of(probe, modelMatcher);

        return this.userRepository.exists(example);
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if (this.ifUserExists(user.getUserId())) {
            System.err.println("UserServiceImpl.findUserByUserId - User already exists for this user id - " + user.getUserId());
            throw new UserAlreadyExistsException("User already exists for this user id - " + user.getUserId());
        } else {
            return this.saveUser(user);
        }
    }

  /*  @Override
    public User login(String userId, String password) {
        User userByUserId = this.findUserByUserId(userId);
        if (!StringUtils.isEmpty(userByUserId)) {
            System.out.println("User present for this user id - " + userId);
            if (userByUserId.getPassword().equals(password))
                return userByUserId;
        } else {
            System.out.println("User Not Found - " + userId);
            throw new IllegalArgumentException("User Not Found - " + userId);
        }
        return null;
    }*/

    @Override
    public void delete(Long id) throws UserNotFoundException {
        if (this.userRepository.existsById(id)) {
            System.out.println("UserServiceImpl.findUserByUserId - User exists for this user id");
            this.userRepository.deleteById(id);
        } else {
            System.err.println("UserServiceImpl.findUserByUserId - User Not Found ");
            throw new UserNotFoundException("User Not Found For This id -  " + id);
        }
    }

    @Override
    public void updateUser(User user) throws UserNotFoundException {
        if (this.ifUserExists(user.getUserId())) {
            System.err.println("UserServiceImpl.findUserByUserId - User already exists for this user id - " + user.getUserId());
            this.userRepository.updateUser(user.getUserName(),user.getUserRole(),user.getUserStatus(),user.getId());
        } else {
            System.err.println("UserServiceImpl.findUserByUserId - User Not Found ");
            throw new UserNotFoundException("User Not Found For This id -  " + user.getUserId());
        }
    }
}
