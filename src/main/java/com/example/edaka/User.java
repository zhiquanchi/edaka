package com.example.edaka;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    // 生成对应的getter和setter方法
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}