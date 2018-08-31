package com.idg.demo.controller;

import com.idg.common.cache.DemoCache;
import com.idg.demo.domain.Module;
import com.idg.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yehao on 16/7/15.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    public static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;
    @Autowired
    private DemoCache cache;
//    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public ModelAndView hello(Integer value) {
        System.out.println(value);
        throw new RuntimeException();
//        return new ModelAndView("demo/demo1");
    }

    @RequestMapping("/json")
    public Map<String, Object> json() {
        logger.info("访问了{}{}接口!", "/demo", "/json");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("hello", "spring4");
        return model;
    }

    @RequestMapping("/test")
    public Module findModule(Integer id) {
        return demoService.findModule(id);
    }

    @RequestMapping("/tx")
    public int testTx() {
        return demoService.testTx();
    }

    @RequestMapping("/testEhcache")
    public String testEhcache() {
        return cache.getString("time");
    }

    @RequestMapping("/message/put")
    public String putMessage(String key, String msg) {
        try {
            rabbitTemplate.convertAndSend(key,msg);
        } catch (AmqpException e) {
            logger.error(e.getMessage(), e);
        }
        return msg;
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String  login(String username, Integer password,@RequestPart("img") MultipartFile img
    ){
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("图片"+ img.toString());
        try {
            img.transferTo(new File("E:/tmp/spring4Demo/uploads/"+img.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
