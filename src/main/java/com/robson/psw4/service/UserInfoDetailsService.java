package com.robson.psw4.service;

import com.robson.psw4.model.User;
import com.robson.psw4.repozitory.UserRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserRepozitory repozitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repozitory.findUserByUsername(username);
        return user.orElseThrow();
    }
}
