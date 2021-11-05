package com.itgood.factory;

import com.itgood.abstracts.Toy;
import com.itgood.beans.Ball;
import com.itgood.beans.Car;
import com.itgood.beans.Child;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/4 10:19
 */
public class ToyFactoryBean implements FactoryBean<Toy> {

    private Child child;

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public Toy getObject() throws Exception {
        switch (child.getWantToy()) {
            case "ball":
                return new Ball("ball");
            case "car":
                return new Car("car");
            default:
                return null;
        }
    }

    @Override
    public Class<Toy> getObjectType() {
        return Toy.class;
    }
}
