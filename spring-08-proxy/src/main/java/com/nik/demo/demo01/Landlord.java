package com.nik.demo.demo01;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 11:49
 */

/**
 * 房东
 */
public class Landlord implements Rent{
    @Override
    public void rent() {
        System.out.println("房东租房！！");
    }
}
