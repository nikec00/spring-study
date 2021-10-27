package com.nik.pojo;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 15:04
 */
public class Address {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
