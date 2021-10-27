package com.service.impl;

import com.dao.IUserDao;
import com.pojo.User;
import com.service.UserService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/5/5 18:17
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = -1)
public class UserServiceImpl implements UserService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<User> listAll() {
        IUserDao mapper = sqlSessionTemplate.getMapper(IUserDao.class);
        return mapper.listAll();
    }

    @Override
    public void accountMoney() {
        IUserDao mapper = sqlSessionTemplate.getMapper(IUserDao.class);
        //lucy少100
        mapper.reduceMoney("lucy",100);
        int i = 10 / 0;
        //mary多100
        mapper.add("mary",100);
    }
}
