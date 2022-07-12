package com.example.security.demo.service;

import com.example.security.demo.entity.User;
import com.example.security.demo.util.ResponseResult;

public interface UserService {
    ResponseResult<String> login(User user);
}
