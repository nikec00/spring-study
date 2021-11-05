package com.itgood;

import com.itgood.beans.Pen;
import com.itgood.config.BeanConfiguration;
import com.itgood.config.ProtoTypeBeanConfiguration;
import com.itgood.prototype.PenType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/5 09:37
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
//        System.out.println("准备初始化IOC容器。。。");
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
//        System.out.println("IOC容器初始化完成。。。");
//        System.out.println("");
//        System.out.println("准备销毁IOC容器。。。");
//        applicationContext.close();
//        System.out.println("IOC容器销毁完成。。。");


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                ProtoTypeBeanConfiguration.class);
        PenType bean = ctx.getBean(PenType.class);
        System.out.println("已经取到了Pen。。。");
        System.out.println("用完Pen了，准备销毁。。。");
        System.out.println("Pen销毁完成。。。");
    }
}
