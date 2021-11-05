package com.itgood.beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/27 17:19
 */
@Component
@Data
@ToString
public class Blue {

    @Value("#{'blue-value-byspel'}")
    private String name;

    @Value("#{2}")
    private Integer order;

}
