package com.pojo;

import com.sun.istack.internal.NotNull;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/15 17:21
 */
public class TestA {
    @NotNull
    private String name;

    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
