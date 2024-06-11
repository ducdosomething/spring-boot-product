package com.example.springbootproduct.config.service;

import com.example.springbootproduct.config.UserPrinciple;
import com.example.springbootproduct.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springbootproduct.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    public User findUserByName(String name){
        return userRepository.findUserByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return UserPrinciple.build(userRepository.findUserByUsername(username));
    }
}
