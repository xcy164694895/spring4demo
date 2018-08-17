package com.idg.demo.service;

import com.idg.demo.domain.Module;

/**
 * Created by yehao on 16/7/18.
 */
public interface DemoService {

    /**
     *
     */
    public Module findModule(int id);


    /**
     * 测试事务
     *
     * @return
     */
    public int testTx();


    public Module findByName(String name);
}
