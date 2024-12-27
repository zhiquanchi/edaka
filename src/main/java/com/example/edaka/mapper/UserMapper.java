package com.example.edaka.mapper;

import com.example.edaka.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
public interface UserMapper {
    @Select("select * from users")
    List<User> getAllUsers();

    @Select("select * from users where id = #{id}")
    User getUserById(int id);

    @Insert("insert into users (username, password) values (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);
}