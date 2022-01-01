package com.itnkc.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/2 00:25
 */
@Configuration
public class UserWebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/fail.html").setViewName("fail");
        registry.addViewController("/list.html").setViewName("list");
    }
}
