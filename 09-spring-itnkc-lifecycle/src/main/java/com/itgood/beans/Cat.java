package com.itgood.beans;

import lombok.Data;
import lombok.ToString;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/5 09:35
 */
@Data
@ToString
public class Cat {

    private String name;

    public Cat() {
        System.out.println("Cat 无参构造方法执行了。。。");
    }

    public Cat(String name) {
        this.name = name;
        System.out.println("Cat 有参构造方法执行了。。。");
    }

    public void setName(String name) {
        System.out.println("Cat set方法执行了。。。");
        this.name = name;
    }

    public void init() {
        System.out.println(name + "被初始化了。。。");
    }
    public void destroy() {
        System.out.println(name + "被销毁了。。。");
    }
}
