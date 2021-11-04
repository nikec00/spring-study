package com.itgood.abstracts;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/4 10:18
 */
public abstract class Toy {

    private String name;

    public Toy(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                '}';
    }
}
