package com.itgood.beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description： @Compont下的属性注入
 * @Author: nkc
 * @Date: 2021/10/27 17:02
 */
@Component
@Data
@ToString
public class Black {

    @Value("black-value-demo")
    private String name;

    @Value("0")
    private Integer order;


}
