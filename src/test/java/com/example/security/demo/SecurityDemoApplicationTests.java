package com.example.security.demo;

import com.example.security.demo.mapper.MenuMapper;
import com.example.security.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class SecurityDemoApplicationTests {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private MenuMapper menuMapper;

    @Test
    void contextLoads() {
        System.out.println(encoder.matches("124", encoder.encode("123")));
    }

    @Test
    public void test1() {
        List<String> strings = menuMapper.selectPermsByUserId(2L);
        System.out.println(strings);
    }
}
