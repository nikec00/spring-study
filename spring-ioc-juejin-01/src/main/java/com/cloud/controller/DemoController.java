package com.cloud.controller;

import com.cloud.service.DemoService;
import com.cloud.service.impl.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/25 14:26
 */
@RestController
public class DemoController {

    private DemoService demoService = new DemoServiceImpl();

    @GetMapping("findAll")
    public List<String> findAll() {
        return demoService.findAll();
    }
}
