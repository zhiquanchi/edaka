package com.example.edaka.service;

import com.example.edaka.entity.User;

import com.example.edaka.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    public User getUserById(int id) {
        return userMapper.selectById(id);
    }


}