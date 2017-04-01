package com.springboot.example.config;

import com.springboot.example.base.filter.ExampleFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public ExampleFilter exampleFilter() {
        return new ExampleFilter();
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
