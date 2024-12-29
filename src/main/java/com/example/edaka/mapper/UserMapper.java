package com.example.edaka.mapper;

import com.example.edaka.entity.User;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from users where id = #{id}")
    User selectById(Integer id);

    @Select("select * from users where username = #{username}")
    User selectByUsername(String username);

    @Insert("insert into users (username, password) values (#{username}, #{password})")
    void insertUser(@Param("username") String username, @Param("password") String password);
}