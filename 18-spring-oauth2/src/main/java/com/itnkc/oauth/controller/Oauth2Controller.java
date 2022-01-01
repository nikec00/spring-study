package com.itnkc.oauth.controller;

import com.alibaba.fastjson.JSON;
import com.itnkc.oauth.entity.User;
import com.itnkc.oauth.service.UserService;
import com.itnkc.oauth.utils.HttpUtils;
import com.itnkc.oauth.utils.SocialUser;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/1 19:01
 */
@Controller
@RequestMapping("/oauth2")
public class Oauth2Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/weibo/success")
    public String webSuccess(@RequestParam("code") String code, HttpSession session) throws Exception {
        System.out.println("code:" + code);
        //根据code获取access_token
        Map<String, String> query = new HashMap<>(5);
        query.put("client_id", "984826289");
        query.put("client_secret", "2ea68b03c29c3f8f5747f2af537b05c7");
        query.put("grant_type", "authorization_code");
        query.put("redirect_uri", "http://192.168.31.237:1010/oauth2/weibo/success");
        query.put("code", code);
        HttpResponse response = HttpUtils.doPost("https://api.weibo.com", "/oauth2/access_token",
                "post", new HashMap<>(), query, new HashMap<>());
        if (response.getStatusLine().getStatusCode() == 200) {
            //获取access_token
            try {
                String json = EntityUtils.toString(response.getEntity());
                SocialUser socialUser = JSON.parseObject(json, SocialUser.class);
                User user = userService.login(socialUser);
                session.setAttribute("loginUser", user);
            } catch (IOException e) {
                e.printStackTrace();
                return "fail";
            } catch (ParseException e) {
                e.printStackTrace();
                return "fail";
            }
        }
        return "list";
    }
}
