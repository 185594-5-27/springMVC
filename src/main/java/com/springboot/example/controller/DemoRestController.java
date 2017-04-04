package com.springboot.example.controller;

import com.springboot.example.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by linzf on 2017/4/2.
 */
@RestController
@RequestMapping(value = "/rest")
public class DemoRestController {

    @RequestMapping(value = "/getJson.do",produces = "application/json;charset=UTF-8")
    public User getJson(){
        return new User("林泽锋");
    }

}
