package com.example.security.demo.service.impl;

import com.example.security.demo.entity.LoginUser;
import com.example.security.demo.entity.User;
import com.example.security.demo.service.UserService;
import com.example.security.demo.util.JwtUtil;
import com.example.security.demo.util.RedisCache;
import com.example.security.demo.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult<String> login(User user) {
        // 进行用户认证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // 如果认证没通过，给出相应提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        // 如果认证通过,使用userid生成一个jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long id = loginUser.getUser().getId();
        String token = JwtUtil.createJWT(id.toString());

        // 将用户信息存入redis,userId作为key
        redisCache.setCacheObject("login:" + token, loginUser);
        // 将jwt信息响应给用户
        return new ResponseResult<>(200, "登录成功", token);
    }
}
