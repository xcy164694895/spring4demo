package com.idg.service;

import com.BaseTest;
import com.idg.demo.service.DemoService;
import com.idg.demo.service.DemoServiceImpl;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author xiongchenyang
 * @version [1.0 , 2018/8/16]
 */
public class DemoServiceTest extends BaseTest {

    @Resource
    private DemoServiceImpl demoService;

    @Test
    public void testTx(){
        demoService.testTx();
    }
}  
