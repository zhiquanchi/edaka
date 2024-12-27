package com.example.edaka.service;

import com.example.edaka.User;
import com.example.edaka.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    public String addUser(User user) {
        userMapper.insertUser(user);
        return user.getUsername();
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

}