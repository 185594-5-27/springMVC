package com.springboot.example.controller;

import com.springboot.example.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by linzf on 2017/3/31.
 */
@Controller
@RequestMapping("/hello/ctrl")
public class HelloController {

    @RequestMapping("/index.do")
    public String hello(){
        return "index";
    }

    @RequestMapping(value="/userLogin.do",produces = "application/json;charset=UTF-8")
    public ModelAndView userLogin(User user){
        if(user!=null){
            System.out.println("user.getUserName()===>"+user.getUserName());
        }else {
            System.out.println("user.getUserName() value is null!");
        }
        return new ModelAndView("index","entity",user);
    }

    @RequestMapping("/loginOut.do")
    public String loginOut() throws Exception {
        throw new Exception("run exception!");
    }

}
