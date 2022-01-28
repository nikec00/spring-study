package com.itnkc.service.impl;

import com.itnkc.service.ZfbService;
import com.itnkc.vo.PayVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/28 21:19
 */
@Service
public class ZfbServiceImpl implements ZfbService {
    @Override
    public PayVo pay() {
        PayVo payVo = new PayVo();
        payVo.setOut_trade_no(UUID.randomUUID().toString());
        payVo.setSubject("macBookPro m1pro 14寸");
        payVo.setTotal_amount("14999.00");
        payVo.setBody("一台苹果笔记本电脑");
        return payVo;
    }
}
