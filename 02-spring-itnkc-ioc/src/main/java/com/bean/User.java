package com.bean;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/25 16:18
 */
public class User {

    private Integer id;

    private Person person;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public User(Integer id, Person person) {
        this.id = id;
        this.person = person;
    }
}
