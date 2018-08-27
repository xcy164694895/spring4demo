package com.idg.demo.service;

import com.idg.demo.domain.UserAuth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiongchenyang
 * @version [1.0 , 2018/8/27]
 */
@Service
public class LoginService implements UserDetailsService{

    @Resource
    private UserAuthService userAuthService;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserAuth userAuth = userAuthService.getByUserName(s);
        if(userAuth != null){
            List<GrantedAuthority>  authorities = new ArrayList<GrantedAuthority>();
            return new User(userAuth.getUserName(),userAuth.getPassword(),authorities);
        }
        throw  new UsernameNotFoundException("User :" + s + " not found");
    }
}
