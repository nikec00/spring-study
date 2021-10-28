package com.itgood.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/28 17:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("zoo")
public class Zoo {

    @Value("动物园")
    private String zooName;

    @Inject
    @Named("xiaohuang")
    private Dog dog;
}
