package com.nik.demo.demo02;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 12:11
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("新增");
    }

    @Override
    public void update() {
        System.out.println("修改");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void find() {
        System.out.println("查询");
    }
}
