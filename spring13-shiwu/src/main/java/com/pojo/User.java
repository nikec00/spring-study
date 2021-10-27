package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/5/5 18:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private int id;

    private String username;

    private int money;
}
