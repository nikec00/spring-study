package com.itgood.configuration;

import com.itgood.beans.Cat;
import com.itgood.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/27 16:51
 */
@Configuration
public class AnnoConfiguration {

    /**
     * 注解方式的setter注入
     *
     * @return
     */
    @Bean
    public Person person() {
        Person person = new Person();
        person.setId(1);
        person.setAge(23);
        person.setName("nkc");
        return person;
    }

    @Bean
    public Cat cat() {
        return new Cat(1, "公");
    }
}
