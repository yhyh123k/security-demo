package com.example.security.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.security.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @author kezhene
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
