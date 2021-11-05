package com.itgood.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/28 17:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Cat {

    @Value("#{admin.name + 'dog!!'}")
    private String name;

    @Autowired(required = false)
    @Qualifier("master") // IOC容器中存放两个相同类型的person，如果不指定其名称就不知道注入哪一个person
    private Person person;

//    @Autowired
//    public Cat(Person person) {
//        this.person = person;
//    }

//    @Autowired
//    public void setPerson(Person person) {
//        this.person = person;
//    }
}
