package com.itgood.beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/27 17:21
 */
@Data
@ToString
@Component
public class Green {

    @Value("#{'copy of' + blue.name}")
    private String name;

    @Value("#{blue.order + 1}")
    private Integer order;
}
