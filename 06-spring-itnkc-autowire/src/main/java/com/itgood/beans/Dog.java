package com.itgood.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/28 17:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("wangcai")
public class Dog {

    private String name = "wangcai";
}
