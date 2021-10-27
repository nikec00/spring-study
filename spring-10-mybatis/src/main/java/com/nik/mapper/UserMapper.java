package com.nik.mapper;

import com.nik.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 14:33
 */
//@Mapper
public interface UserMapper {

    List<User> listAll();
}
