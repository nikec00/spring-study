package com.itgood.configuration;

import com.itgood.beans.AwaredTestBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/1 14:56
 */
@Configuration
@ComponentScan("com.itgood.beans")
public class AwareConfiguration {

    @Bean
    @Qualifier(value = "awaredTestBean")
    public AwaredTestBean awaredTestBean() {
        return new AwaredTestBean();
    }

}
