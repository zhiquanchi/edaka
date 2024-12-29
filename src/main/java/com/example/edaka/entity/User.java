package com.example.edaka.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.NonNull;

@Data
@Table(value = "users")
public class User {

    // 生成对应的getter和setter方法
    @Id(keyType = KeyType.Auto)
    private Integer id;

    @NonNull
    private String username;

    private String password;

}