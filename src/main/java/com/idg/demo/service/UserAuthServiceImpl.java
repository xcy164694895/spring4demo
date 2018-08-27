package com.idg.demo.service;

import com.idg.demo.dao.UserAuthMapper;
import com.idg.demo.domain.UserAuth;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author xiongchenyang
 * @version [1.0 , 2018/8/27]
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Resource
    private UserAuthMapper mapper;

    public UserAuth getByUserName(String userName) {
        Assert.notNull(userName,"要查询的用户名不允许为空！");
        UserAuth userAuth = mapper.getByUserName(userName);
        return userAuth;
    }
}
