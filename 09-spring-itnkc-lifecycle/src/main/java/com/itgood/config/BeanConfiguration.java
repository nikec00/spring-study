package com.itgood.config;

import com.itgood.beans.Cat;
import com.itgood.beans.Dog;
import com.itgood.beans.Pen;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/5 09:36
 */
@Configuration
@ComponentScan("com.itgood.beans")
public class BeanConfiguration {

    /**
     * 在执行初始化方法的时候会先对属性进行赋值。执行 （构造） 或者 （set方法）
     *
     * @return
     */
//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    public Cat cat() {
//        return new Cat("兜兜");
//    }
//
//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    public Dog dog() {
//        return new Dog("哈士奇");
//    }
    @Bean(initMethod = "open",destroyMethod = "close")
    public Pen pen() {
        return new Pen();
    }
}
