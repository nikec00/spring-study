package com.itgood.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/5 09:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dog {

    private String name;


    public void init() {
        System.out.println(name + "被初始化了。。。");
    }

    public void destroy() {
        System.out.println(name + "被销毁了。。。");
    }


}
