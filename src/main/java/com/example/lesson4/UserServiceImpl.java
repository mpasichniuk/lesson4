package com.example.lesson4;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public  class UserServiceImpl implements UserDetailsService {


    private final User userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.find(username);
    }

}