package com.itnkc.web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.itnkc.config.AlipayTemplate;
import com.itnkc.service.ZfbService;
import com.itnkc.vo.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2022/1/28 21:15
 */
@Controller
public class ZfbWebController {

    @Autowired
    private ZfbService zfbService;

    @Autowired
    private AlipayTemplate alipayTemplate;

    @ResponseBody
    @GetMapping(value = "/zfb/pay", produces = "text/html")
    public String pay() throws AlipayApiException {
        PayVo payVo = zfbService.pay();
        String pay = alipayTemplate.pay(payVo);
        System.out.println(pay);
        return pay;
    }


    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "hello";
    }

    /**
     * 支付成功后回调
     *
     * @return
     */
    @GetMapping("/paySuccess.html")
    public String success() {
        return "paySuccess";
    }

    /**
     * 支付成功后异步回调
     *
     * @return
     */
    @PostMapping("/notifySuccess.html")
    @ResponseBody
    public String notifySuccess(HttpServletRequest request) throws AlipayApiException {
        System.out.println("收到支付宝异步通知******************");
        // 只要收到支付宝的异步通知，返回 success 支付宝便不再通知
        // 获取支付宝POST过来反馈信息
        //TODO 需要验签
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayTemplate.getAlipay_public_key(),
                alipayTemplate.getCharset(), alipayTemplate.getSign_type()); //调用SDK验证签名

        if (signVerified){
            System.out.println("支付宝异步通知验签成功");
            //修改订单状态
            System.out.println("订单状态修改成功");
            return "success";
        }else {
            System.out.println("支付宝异步通知验签失败");
            return "error";
        }
    }
}
