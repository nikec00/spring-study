package com.itgood.configuration;

import com.itgood.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/28 17:13
 */
@Configuration
@ComponentScan("com.itgood.bean")
public class ComponentConfiguration {

    @Bean
    public Person master() {
        return new Person("master");
    }
}
