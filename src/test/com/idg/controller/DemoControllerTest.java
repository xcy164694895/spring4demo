package com.idg.controller;

import com.BaseTest;
import com.idg.demo.controller.DemoController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcBuilderSupport;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author xiongchenyang
 * @version [1.0 , 2018/8/18]
 */
public class DemoControllerTest extends BaseTest{

//    @Resource
//    private DemoController demoController;

    @Test
    public void testController() throws Exception {
        DemoController demoController = new DemoController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();

        mockMvc.perform(get("/demo/hello","111")).andExpect(view().name("index"));
    }
}  
