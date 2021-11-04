package com.itgood;

import com.itgood.bean.AwaredTestBean;
import com.itgood.configuration.AwareConfiguration;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/1 14:57
 */
public class AwareApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AwareConfiguration.class);
        AwaredTestBean contextBean = context.getBean(AwaredTestBean.class);
        // 延时查找
        ObjectProvider<AwaredTestBean> beanProvider = context.getBeanProvider(AwaredTestBean.class);
        contextBean.printBeanNames();
        System.out.println(contextBean.getBeanName());
    }
}
