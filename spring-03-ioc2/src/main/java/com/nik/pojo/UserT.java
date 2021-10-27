package com.nik.pojo;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 14:20
 */
public class UserT {

    private String name;

    public UserT() {
        System.out.println("userT被创建了！！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
