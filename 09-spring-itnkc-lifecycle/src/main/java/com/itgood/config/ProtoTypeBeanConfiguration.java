package com.itgood.config;

import com.itgood.prototype.PenType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/5 10:20
 */
@Configuration
public class ProtoTypeBeanConfiguration {

    /**
     * 原型Bean的销毁不包括destroy-method
     * @return
     */
    @Bean(initMethod = "open",destroyMethod = "close")
    @Scope(value="prototype")
    public PenType penType() {
        return new PenType();
    }
}


