package com.nik.pojo;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 12:46
 */
public class Hello {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}

