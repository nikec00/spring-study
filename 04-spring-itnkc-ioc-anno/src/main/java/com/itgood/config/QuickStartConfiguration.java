package com.itgood.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/27 16:22
 */
@Configuration
//@ComponentScan("com.itgood.bean")
@ImportResource("classpath:bean.xml")// 引入xml配置文件
public class QuickStartConfiguration {

}
