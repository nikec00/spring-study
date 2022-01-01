package com.itnkc.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/1 19:01
 */
@Controller
@RequestMapping("/oauth2")
public class Oauth2Controller {

    @GetMapping("/weibo/success")
    public String webSuccess(@RequestParam("code") String code) {
        System.out.println("code:" + code);
        return "list";
    }
}
