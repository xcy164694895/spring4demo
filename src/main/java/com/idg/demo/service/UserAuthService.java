package com.idg.demo.service;

import com.idg.demo.domain.UserAuth;

/**
 * @author xiongchenyang
 * @version [1.0 , 2018/8/27]
 */
public interface UserAuthService {

    UserAuth getByUserName(String userName);
}  
