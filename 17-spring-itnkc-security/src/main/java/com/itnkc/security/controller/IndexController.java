package com.itnkc.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/28 16:12
 */
@RestController
public class IndexController {

    @GetMapping("index")
    public String index() {
        return "success";
    }

    @GetMapping("index2")
    public String index2() {
        int i = 1 / 0;
        return "success";
    }
}
