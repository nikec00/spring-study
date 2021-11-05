package com.itgood.beans;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/1 16:20
 */
@Component
public class Dog {

    @Autowired
    private ObjectProvider<Person> person;

    public void m1() {
        System.out.println(person.getIfAvailable() != null ? person.toString() : new Person().toString());
    }
}
