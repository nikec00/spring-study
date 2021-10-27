package com.itgood.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/27 16:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    private Integer id;

    private String name;

    private Integer age;
}
