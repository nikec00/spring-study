package com.nik.demo.demo02;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 12:12
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        UserServiceProxy serviceProxy = new UserServiceProxy();
        serviceProxy.setUserService(service);

        serviceProxy.save();
    }
}
