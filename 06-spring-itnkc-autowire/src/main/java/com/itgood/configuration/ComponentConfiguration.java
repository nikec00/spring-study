package com.itgood.configuration;

import com.itgood.beans.Dog;
import com.itgood.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/28 17:13
 */
@Configuration
@ComponentScan("com.itgood.beans")
public class ComponentConfiguration {

    @Bean
    public Person master() {
        return new Person("master");
    }

    @Bean
    public Dog xiaohuang() {
        return new Dog("xiaohuang");
    }
}
