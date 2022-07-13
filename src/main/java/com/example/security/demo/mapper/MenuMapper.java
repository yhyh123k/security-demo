package com.example.security.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.security.demo.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kezhene
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询用户相关权限
     * @param id 用户id
     * @return 用户权限信息
     */
    List<String> selectPermsByUserId(Long id);
}
