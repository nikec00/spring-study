package com.itgood.beans;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/27 17:08
 */
@Component
@PropertySource("classpath:red.properties")
@ToString
public class Red {

    @Value("${red.name}")
    private String name;


    @Value("${red.order}")
    private Integer order;
}
