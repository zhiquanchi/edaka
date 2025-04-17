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
         // 1. 根据用户名查询用户
         User user = userMapper.selectByUsername(username);
         // 2. 判断用户是否存在，并且密码是否匹配
         if (user != null && user.getPassword().equals(password)) {
             return user; // 用户名和密码都正确，返回用户对象
         }
         return null; // 用户名或密码错误，返回 null
    }

    public void insertUser(String username, String password) {
        userMapper.insertUser(username, password);
    }


}