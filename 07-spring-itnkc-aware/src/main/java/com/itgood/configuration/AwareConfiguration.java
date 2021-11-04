package com.itgood.configuration;

import com.itgood.bean.AwaredTestBean;
import org.junit.Before;
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
@ComponentScan("com.itgood.bean")
public class AwareConfiguration {

    @Bean
    @Qualifier(value = "awaredTestBean")
    public AwaredTestBean awaredTestBean() {
        return new AwaredTestBean();
    }

}
