package com.springboot.example.config;

import com.springboot.example.base.filter.ExampleFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by linzf on 2017/3/31.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.springboot.example")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 功能描述：springMVC初始化配置信息
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 功能描述：配置过滤器
     *
     * @return
     */
    @Bean
    public ExampleFilter exampleFilter() {
        return new ExampleFilter();
    }

    /**
     * 功能描述：配置附件上传的配置
     *
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(10000000);
        return commonsMultipartResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 增加拦截器的监听
        registry.addInterceptor(exampleFilter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 继承WebMvcConfigurerAdapter并重写addResourceHandlers方法中的addResourceHandler来设置文件的放置位置,addResourceLocations来设置对外暴露的访问路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
