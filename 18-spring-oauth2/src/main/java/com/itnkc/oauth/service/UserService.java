package com.itnkc.oauth.service;

import com.itnkc.oauth.entity.User;
import com.itnkc.oauth.utils.SocialUser;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/1 19:12
 */
public interface UserService {
    User login(SocialUser socialUser);
}
