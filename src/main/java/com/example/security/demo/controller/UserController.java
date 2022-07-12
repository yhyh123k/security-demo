package com.example.security.demo.controller;

import com.example.security.demo.entity.User;
import com.example.security.demo.service.UserService;
import com.example.security.demo.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author kezhene
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('test')")
    public ResponseResult<String> hello() {
        return new ResponseResult<>(201, "获取数据成功", "hello");
    }
}
