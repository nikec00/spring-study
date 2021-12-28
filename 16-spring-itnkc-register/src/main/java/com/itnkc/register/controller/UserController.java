package com.itnkc.register.controller;

import com.itnkc.register.entity.User;
import com.itnkc.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description： 注册登录
 * @Author: nkc
 * @Date: 2021/12/28 10:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册功能
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    /**
     * 短信验证码功能
     */
    @GetMapping("sendSms")
    public String sendSms(@RequestParam("phone")String phone) {
        return userService.sendSms(phone);
    }

}
