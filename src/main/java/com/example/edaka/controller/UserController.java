package com.example.edaka.controller;

import com.example.edaka.User;
import com.example.edaka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        if(userService.getUserById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
        return userService.getUserById(id);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public String handleException(ResponseStatusException e) {
        return e.getMessage();
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        userService.addUser(user);
        return "add success";
    }
}
