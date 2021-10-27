package com.nik.config;

import com.nik.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 22:13
 */
// @Configuration代表这是一个配置类，就和我们之前看到的bean.xml,同时也会被注入到spring容器当中
@Configuration
//指定要扫描的包，这个包下的注解会生效
@ComponentScan("com.nik.pojo")
@Import(NkcConfig.class)
public class UserConfig {

    // 注册一个bean 就等价于我们之前写的bean标签
    //这个方法的名字，就相当于bean标签中的id属性
    //这个方法的返回值，就相当于class属性
    @Bean
    public User getUser(){
        return new User();
    }
}
