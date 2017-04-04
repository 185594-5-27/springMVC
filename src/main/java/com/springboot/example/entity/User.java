package com.springboot.example.entity;


/**
 * Created by linzf on 2017/3/31.
 */
public class User {

    public User() {
        super();
    }

    public User(String userName) {
        this.userName = userName;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {

        return id;
    }

    public String getUserName() {
        return userName;
    }

    private Integer id;


    private String userName;


}
