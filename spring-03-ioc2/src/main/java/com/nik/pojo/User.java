package com.nik.pojo;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 14:12
 */
public class User {
    public User() {
        System.out.println("user被创建了！！");
    }

    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("名字：" + this.name);
    }
}
