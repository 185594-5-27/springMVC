package com.springboot.example.hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import com.springboot.example.config.MyMvcConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by linzf on 2017/4/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class HelloTest {
    private MockMvc mockMvc;
    @Autowired
    MockHttpSession mockHttpSession;
    @Autowired
    WebApplicationContext was;
    @Autowired
    MockHttpServletRequest mockHttpServletRequest;

    @Before
    public void before(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.was).build();
    }

    @Test
    public void testNormalController() throws Exception {
        mockMvc.perform(get("/hello/ctrl/index.do"))// 需要测试并响应的url地址
                .andExpect(status().isOk())//预期返回的结果是200
                .andExpect(view().name("index"))//预期的页面的名称是index
                .andExpect(forwardedUrl("/WEB-INF/classes/view/index.jsp"));//预期返回的页面的地址

    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/rest/getJson.do"))// 需要测试并响应的url地址
                .andExpect(status().isOk())//预期返回的结果是200
                .andExpect(content().contentType("application/json;charset=UTF-8"))//数据返回的头部文件信息
                .andExpect(content().string("{\"id\":null,\"userName\":\"林泽锋\"}"));// 返回的json的信息
    }

}
