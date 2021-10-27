package com.itgood.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/27 16:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
@Component
public class Person {

    private Integer id;

    private String name;

}
