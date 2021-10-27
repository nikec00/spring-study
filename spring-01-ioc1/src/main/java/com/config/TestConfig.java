package com.config;

import com.pojo.TestA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/15 17:18
 */
@Configuration
//@ComponentScan("com.pojo")
public class TestConfig {

    @Bean
    public TestA test(){
        TestA testA = new TestA();
        testA.setName("倪克成");
        testA.setHobby("敲代码");
        return testA;
    }

}
