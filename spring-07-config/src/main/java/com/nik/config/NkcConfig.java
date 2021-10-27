package com.nik.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 22:17
 */
@Configuration
@Import(UserConfig.class)
public class NkcConfig {
}
