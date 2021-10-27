package com.nik.demo.demo01;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 11:51
 */

/**
 * 中介代理
 */
public class Proxy {
    //组合
    private Landlord landlord;

    public Proxy() {
    }

    public Proxy(Landlord landlord) {
        this.landlord = landlord;
    }

    //中介代理了房东要租房的这件事
    public void rent() {
        seeHouse();
        landlord.rent();
        hetong();
        fare();
    }

    public void seeHouse() {
        System.out.println("中介带你看房");
    }
    public void hetong() {
        System.out.println("签合同");
    }

    public void fare() {
        System.out.println("收中介费");
    }
}
