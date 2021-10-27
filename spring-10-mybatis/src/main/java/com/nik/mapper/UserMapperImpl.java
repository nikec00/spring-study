package com.nik.mapper;

import com.nik.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 15:03
 */
@Component("userMapper")
public class UserMapperImpl implements UserMapper{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<User> listAll() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.listAll();
    }
}
