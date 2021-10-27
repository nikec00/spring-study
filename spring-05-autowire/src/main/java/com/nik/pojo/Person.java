package com.nik.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 20:11
 */
public class Person {
    private String name;
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;

    public String getName() {
        return name;
    }
    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                ", dog=" + dog +
                '}';
    }
}
