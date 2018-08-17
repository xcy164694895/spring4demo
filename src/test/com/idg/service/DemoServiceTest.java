package com.idg.service;

import com.BaseTest;
import com.idg.demo.domain.Module;
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
    private DemoService demoService;

    @Test
    public void testTx(){
        demoService.testTx();
    }


    @Test
    public void testFindAll(){
        String name = "熊晨阳！";
        Module module = demoService.findByName(name);

    }
}  
