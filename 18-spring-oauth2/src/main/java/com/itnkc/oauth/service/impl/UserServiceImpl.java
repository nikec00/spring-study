package com.itnkc.oauth.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itnkc.oauth.dao.UserDao;
import com.itnkc.oauth.entity.User;
import com.itnkc.oauth.service.UserService;
import com.itnkc.oauth.utils.HttpUtils;
import com.itnkc.oauth.utils.SocialUser;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/1 19:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(SocialUser socialUser) {
        String uid = socialUser.getUid();
        User userOne = userDao.selectOne(uid);
        if (userOne != null) {
            User user = new User();
            long expiresIn = socialUser.getExpires_in();
            String accessToken = socialUser.getAccess_token();
            Integer id = userOne.getId();
            user.setId(id);
            user.setAccess_token(accessToken);
            user.setExpires_in(String.valueOf(expiresIn));
            userDao.update(user);
            userOne.setExpires_in(String.valueOf(expiresIn));
            userOne.setAccess_token(accessToken);
            return userOne;
        } else {
            User user = new User();
            try {
                //注册
                Map<String, String> query = new HashMap<>(2);
                query.put("access_token", socialUser.getAccess_token());
                query.put("uid", socialUser.getUid());
                HttpResponse response = HttpUtils.doGet("https://api.weibo.com", "/2/users/show.json", "get", new HashMap<>(), query);
                if (response.getStatusLine().getStatusCode() == 200) {
                    String json = EntityUtils.toString(response.getEntity());
                    JSONObject jsonObject = JSON.parseObject(json);
                    String name = jsonObject.getString("name");
                    String gender = jsonObject.getString("gender");
                    user.setNikeName(name);
                    user.setGender(gender);
                    user.setAccess_token(socialUser.getAccess_token());
                    user.setExpires_in(String.valueOf(socialUser.getExpires_in()));
                    user.setSocial_uid(socialUser.getUid());
                    userDao.insert(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;

        }
    }
}
