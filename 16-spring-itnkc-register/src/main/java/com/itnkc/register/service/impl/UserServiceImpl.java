package com.itnkc.register.service.impl;

import com.itnkc.register.component.SmsComponent;
import com.itnkc.register.dao.UserDao;
import com.itnkc.register.entity.User;
import com.itnkc.register.service.UserService;
import com.itnkc.register.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/28 10:17
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String SMS_CODE_CACHE_PREFIX = "sms:code:";

    @Autowired
    private UserDao userDao;

    @Autowired
    private SmsComponent smsComponent;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 1.校验注册数据传参格式正确性
     * 2.校验账号和手机是否唯一
     * 3.校验验证码是否正确
     * 4.密码加密
     * 5.入库
     *
     * @param user
     * @return
     */
    @Override
    public String register(User user) {
        String username = user.getUsername();
        String phone = user.getPhone();
        String code = user.getCode();
        // 校验用户名和手机号唯一性
        checkUserNameUnique(username);
        checkPhoneUnique(phone);
        String rdsCode = redisTemplate.opsForValue().get(SMS_CODE_CACHE_PREFIX + phone);
        if (StringUtils.isEmpty(rdsCode)) {
            return "验证码校验错误！！";
        }
        String s = rdsCode.split("_")[0];
        if (!code.equals(s)) {
            return "验证码校验错误！！";
        }
        // 密码加密
        String password = user.getPassword();
        String encode = MD5Utils.md5(password);
        user.setPassword(encode);
        userDao.register(user);
        redisTemplate.delete(SMS_CODE_CACHE_PREFIX + phone);
        return "注册成功！";
    }

    public void checkUserNameUnique(String username) {
        Integer count = userDao.checkUserNameUnique(username);
        if (count > 0) {
            throw new RuntimeException("用户名账号已存在，请修改！");
        }
    }

    public void checkPhoneUnique(String phone) {
        Integer count = userDao.checkPhoneUnique(phone);
        if (count > 0) {
            throw new RuntimeException("该手机号已存在，请修改！");
        }
    }

    @Override
    public String sendSms(String phone) {
        if ("".equals(phone)) {
            return "请输入手机号！";
        }
        String codes = redisTemplate.opsForValue().get(SMS_CODE_CACHE_PREFIX + phone);
        // 接口防刷
        if (!StringUtils.isEmpty(codes)) {
            long time = Long.parseLong(codes.split("_")[1]);
            if (System.currentTimeMillis() - time < 60000) {
                return "请在60s之后再发送验证码查询!";
            }
        }
        // 生成验证码（4位数）
        int i = (int) (Math.random() * 8998) + 1000 + 1;
        String rdsCode = i + "_" + System.currentTimeMillis();
        smsComponent.sendSmsCode(phone, Integer.toString(i));
        redisTemplate.opsForValue().set(SMS_CODE_CACHE_PREFIX + phone, rdsCode, 10, TimeUnit.MINUTES);
        return "发送成功";
    }


}
