package com.xuefei.service.impl;

import com.xuefei.bean.*;
import com.xuefei.exception.PageNotFoundException;
import com.xuefei.mapper.DepartmentMapper;
import com.xuefei.mapper.UserMapper;
import com.xuefei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    @Transactional
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

    @Override
    public List<Admin> findAllUsers() {
        List<Admin> admins = new ArrayList<>();
        List<User> users = userMapper.selectByExample(null);

        for (User user : users) {
            Admin admin = new Admin();
            System.out.println(user.getDeptId());
            Department department = departmentMapper.selectByPrimaryKey(user.getDeptId());
            if(department == null){
                throw new PageNotFoundException("对不起,有错误");
            }
            admin.setUsername(user.getUsername());
            admin.setMobile(user.getMobile());
            admin.setId(user.getId());
            admin.setDepartName(department.getName());
            admin.setEmail(user.getEmail());
            admin.setSex(user.getSex());
            admin.setRealname(user.getRealname());
            admins.add(admin);
        }
        return admins;
    }

    @Override
    public User findDepartmentById(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int updateUser(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }

    @Override
    public int deleteBatch(List<String> del_ids) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(del_ids);
        int i = userMapper.deleteByExample(userExample);
        return i;
    }

    @Override
    public int deleteUser(String id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int saveUser(User user) {
        int i = userMapper.insert(user);
        return i;
    }
}
