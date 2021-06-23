package com.example.serviceauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author xuzihan
 * @version 1.0
 * @description: TODO
 * @data
 **/
@Service
public class UserDetailsServiceImpl extends UserDetails{
    @Autowired(required = false)
    private MyUserDao myUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserDao.findByUsername(username);
        System.out.println(username);
        if (myUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if (username.equals("admin") || username.equals("ffzs")){
            return new User(username, myUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN, ROLE_USER"));
        }
        return new User(username, myUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
