package com.springboot.example.config;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebResult;

/**
 * @author:linzf
 * @since: 2017-04-01.
 * @version:1.0
 * @describe:
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 功能描述:所有的系统运行中抛出的错误都会给当前的方法拦截并处理
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest webRequest) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder
    public void initBunder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }




}
