package com.saitej.service;

import com.saitej.model.User;
import com.saitej.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int saveUser(User user) {
        return userRepository.saveUser(user);
    }
}
