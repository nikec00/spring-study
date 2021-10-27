package com.nik.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 21:06
 */
//@Component: 组件 等价于 <bean id="user" class="com.com.nik.pojo.User"/>
@Component
public class User {
    //相当于 <property name="name" value="nkc"/>
    @Value("NKC")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
