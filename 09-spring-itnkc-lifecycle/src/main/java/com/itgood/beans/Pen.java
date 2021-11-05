package com.itgood.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/5 09:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pen {

    private Integer ink;

    /**
     * 如果不使用 @Component 注解来注册 Bean 而转用 <bean> / @Bean 的方式，
     * 那 @PostConstruct 与 @PreDestroy 注解是可以与 init-method / destroy-method 共存的
     * JSR250 规范的执行优先级高于 init / destroy。
     */

    public void open() {
        System.out.println("init-method - 打开钢笔。。。");
    }

    public void close() {
        System.out.println("destroy-method - 合上钢笔。。。");
    }

    /**
     * 被 @PostConstruct 和 @PreDestroy 注解标注的方法，
     * 与 init-method / destroy-method 方法的声明要求是一样的，访问修饰符也可以是 private 。
     */
    @PostConstruct // 等同于初始化方法
    public void addInk() {
        System.out.println("钢笔中已加满墨水。。。");
        this.ink = 100;
    }

    @PreDestroy // 等同于销毁方法
    public void outwellInk() {
        System.out.println("钢笔中的墨水都放干净了。。。");
        this.ink = 0;
    }

    @Override
    public String toString() {
        return "Pen{" + "ink=" + ink + '}';
    }
}
