package com.example.springsecurity.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 授权服务器配置
 * @author yh
 * @date 2022/7/13 22:15
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 配置client-id
                .withClient("admin")
                .secret(passwordEncoder.encode("112233"))
                // 配置访问令牌的有效期
                .accessTokenValiditySeconds(3600)
                // 用于授权成功后跳转
                .redirectUris("http://www.baidu.com")
                .scopes("all")
                // 表示授权类型
                .authorizedGrantTypes("authorization_code");
    }
}
