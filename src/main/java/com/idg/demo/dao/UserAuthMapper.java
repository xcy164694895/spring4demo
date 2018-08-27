package com.idg.demo.dao;

import com.idg.common.mybatis.MybatisMapper;
import com.idg.demo.domain.UserAuth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author xiongchenyang
 * @version [1.0 , 2018/8/27]
 */
//@Repository
public interface UserAuthMapper extends MybatisMapper {

    Integer insert(UserAuth userAuth);

    UserAuth getByUserName(@Param("userName") String userName);
}
