package com.itnkc.vo;

import lombok.Data;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/28 21:12
 */
@Data
public class PayVo {
    private String out_trade_no; // 商户订单号 必填
    private String subject; // 订单名称 必填
    private String total_amount;  // 付款金额 必填
    private String body; // 商品描述 可空
}
