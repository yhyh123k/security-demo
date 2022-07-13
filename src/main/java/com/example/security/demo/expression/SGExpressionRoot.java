package com.example.security.demo.expression;

import com.example.security.demo.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 自定义权限校验
 * @author kezhene
 */
@Component("sg")
public class SGExpressionRoot {

    public boolean hasAuthority(String authority) {
        // 获取当前用户权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        Set<String> setPermissions = new HashSet<>(permissions);

        // 判断当前用户是否有对应的权限
        if (setPermissions.contains(authority)) {
            return true;
        }
        return false;
    }
}
