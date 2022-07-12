package com.example.security.demo;

import com.example.security.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityDemoApplicationTests {

    @Autowired
    private PasswordEncoder encoder;

    @Test
    void contextLoads() {
        System.out.println(encoder.matches("124", encoder.encode("123")));
    }

}
