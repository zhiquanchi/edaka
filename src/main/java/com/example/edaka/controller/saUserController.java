package com.example.edaka.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.example.edaka.entity.User;
import com.example.edaka.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class saUserController {

    private static final Logger log = LoggerFactory.getLogger(saUserController.class);
    @Autowired
    private UserService userService;

    //    注册
    @PostMapping("register")
    public ResponseEntity<String> register(String username, String password) {
        // 判断用户名和密码是否为空
        if (username == null || password == null || username.equals("") || password.equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("用户名或密码不能为空");
        }
//        使用正则表达式判断来过滤掉不合适的用户名和密码
        else if(!username.matches("^[a-zA-Z0-9]{6,16}$") || !password.matches("^[a-zA-Z0-9]{6,16}$")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("用户名或密码不符合规范，只能是大小写英文字幕和数字");
        }

        else if(userService.getUserByUsername(username) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("用户名已存在");
        }
        else {
            userService.insertUser(username, password);
            return ResponseEntity.status(HttpStatus.OK).body("注册成功");
        }
    }

    // 测试登录，浏览器访问： http://localhost:8080/user/doLogin?username=zhang&password=123456
    @PostMapping("doLogin")
    public ResponseEntity<String> doLogin(String username, String password) {
        User userByUsernameAndPassword = userService.getUserByUsernameAndPassword(username, password);
        if (userByUsernameAndPassword != null) {

            StpUtil.login(userByUsernameAndPassword.getId());
            return ResponseEntity.status(HttpStatus.OK).body(StpUtil.getTokenValue());
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("登录失败");
        }

    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @GetMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

//    获取当前用户的信息
    @GetMapping("getUserInfo")
    public String getUserInfo() {
        return "当前会话用户id：" + StpUtil.getTokenName() + StpUtil.getTokenValue();
    }


}
