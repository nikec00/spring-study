package com.nkc;

import com.nkc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/18 23:10
 */
@SpringBootTest
public class RedisTest {

    public static final String KEY = "top";

    private static List<User> users = new ArrayList<>(3);

    @Autowired
    private StringRedisTemplate redisTemplate;

    static {
        users.add(new User("倪克成", 88d));
        users.add(new User("王卡妮", 90d));
        users.add(new User("李白", 100d));
    }

    @Test
    public void addZSet() {
        for (User user : users) {
            Boolean aBoolean = redisTemplate.opsForZSet().add(KEY, user.getName(), user.getScore());
            //设置过期时间
            redisTemplate.expire(KEY, 5, TimeUnit.MINUTES);
            System.out.println("添加状态：" + aBoolean);
        }
    }

    @Test
    public void getZSet() {
        Set<ZSetOperations.TypedTuple<String>> set = redisTemplate.opsForZSet().rangeByScoreWithScores(KEY, 0, 100);
        System.out.println(set);
    }
}
