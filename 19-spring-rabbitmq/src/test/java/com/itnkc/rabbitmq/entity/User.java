package com.itnkc.rabbitmq.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/5 22:28
 */
@Data
@ToString
public class User {
    private String name;

    private String gender;

    private Integer age;

}
