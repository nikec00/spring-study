package com.config;

import com.bean.Cat;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/10 11:26
 */
@Configuration
public class SingletonBeansConfiguration {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("兜兜");
        return cat;
    }
}
