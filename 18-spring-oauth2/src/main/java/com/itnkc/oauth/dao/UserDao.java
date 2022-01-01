package com.itnkc.oauth.dao;

import com.itnkc.oauth.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/1 19:13
 */
@Mapper
public interface UserDao {
    User selectOne(@Param("uid") String uid);

    void update(User user);

    void insert(User user);
}
