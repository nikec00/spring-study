package com.cloud.factory;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/25 14:30
 */
public class BeanFactory {

    private static Properties properties;

    public BeanFactory() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getDemoDAO("demoDAO"));
        }
    }

    static {
       properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getDemoDAO(String demoDAOName){
        try {
            return Class.forName(properties.getProperty(demoDAOName)).newInstance();
        } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
        }
    }
}
