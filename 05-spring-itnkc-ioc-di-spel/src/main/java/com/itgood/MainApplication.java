package com.itgood;

import com.itgood.bean.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/27 17:03
 */
public class MainApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.itgood.bean");
        Black black = applicationContext.getBean(Black.class);
        Red red = applicationContext.getBean(Red.class);
        Blue blue = applicationContext.getBean(Blue.class);
        Green green = applicationContext.getBean(Green.class);
        System.out.println(black);
        System.out.println(red);
        System.out.println(blue);
        System.out.println(green);
    }
}
