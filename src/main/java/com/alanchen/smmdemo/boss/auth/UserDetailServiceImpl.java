package com.alanchen.smmdemo.boss.auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2019-10-31
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //TODO 从数据库取数据
        String password = "$2a$10$hoIKMK7haFkAShKNHctxceBSCigIFOkrjOh7XNDF8s0py14RNVkXW"; //admin BCryptPasswordEncoder加密后的字符串
        //String password = userServiceImp.getUserPassWord(userName);
        return new User(userName, password, getAuthority());  //emptyList()
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}