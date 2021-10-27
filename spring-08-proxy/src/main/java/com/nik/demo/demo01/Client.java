package com.nik.demo.demo01;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 11:50
 */

/**
 * 租客
 */
public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Landlord landlord = new Landlord();
        //代理，中介帮房东租房子，但是呢？代理一般会有一些附属操作
        Proxy proxy = new Proxy(landlord);
        //你不用面对房东，直接跟中介租房即可
        proxy.rent();
    }
}
