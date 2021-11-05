package com.itgood.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/28 17:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("admin")
public class Person {

    private String name = "admin";
}
