package com.itnkc.register.dao;

import com.itnkc.register.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/28 10:15
 */
@Mapper
public interface UserDao {
    Integer checkUserNameUnique(String username);

    Integer checkPhoneUnique(String phone);

    void register(User user);
}
