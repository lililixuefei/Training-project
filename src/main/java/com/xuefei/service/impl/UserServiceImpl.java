package com.xuefei.service.impl;

import com.xuefei.bean.User;
import com.xuefei.bean.UserExample;
import com.xuefei.mapper.UserMapper;
import com.xuefei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 1) {
            return users.get(0);
        }else{
            return null;
        }
    }
}
