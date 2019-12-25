package com.xuefei.service;

import com.xuefei.bean.Admin;
import com.xuefei.bean.Patient;
import com.xuefei.bean.User;

import java.util.List;

public interface UserService {

    public User checkUser(String username, String password);

    public List<Admin> findAllUsers();

    public User findDepartmentById(String id);

    int updateUser(User user);

    int deleteBatch(List<String> del_ids);

    int deleteUser(String id);

    int saveUser(User user);
}
