package com.itnkc.security.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/28 16:47
 */
@Service
public class LoginService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        String pwd = "123456";
        return new User(username, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,"));
    }
}
