package com.itgood.config;

import com.itgood.bean.Tom;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/4 10:35
 */
@Configuration
@ComponentScan("com.itgood.bean")
public class ScopeConfiguration {


//    @Bean
//    public Tom tom2() {
//        return new Tom();
//    }
}
