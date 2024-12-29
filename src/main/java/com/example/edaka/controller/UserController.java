package com.example.edaka.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.edaka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController  {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public Object getUserById(@PathVariable int id) {
        if(StpUtil.isLogin()){
            return userService.getUserById(id);
        }
        else {
            return "请先登录";
        }

    }
}
