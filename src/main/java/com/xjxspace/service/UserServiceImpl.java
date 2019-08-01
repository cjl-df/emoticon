package com.xjxspace.service;


import com.xjxspace.mapper.system.UserMapper;
import com.xjxspace.model.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findByUserAccount(String userAccout) {
       User user = userMapper.getUserByUserAccount(userAccout);
        return user;
    }
}
