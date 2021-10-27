package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/5/5 18:14
 */
@Mapper
public interface IUserDao {

    List<User> listAll();

    void add(@Param("username") String name,@Param("money") int money);

    void reduceMoney(@Param("username") String name,@Param("money") int money);
}
