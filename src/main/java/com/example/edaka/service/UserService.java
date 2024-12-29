package com.example.edaka.service;

import com.example.edaka.controller.saUserController;
import com.example.edaka.entity.User;

import com.example.edaka.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(saUserController.class);


    @Autowired
    private UserMapper userMapper;


    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
         return userMapper.selectByUsername(username);

    }

    public void insertUser(String username, String password) {
        userMapper.insertUser(username, password);
    }


}