package com.xuefei.service.impl;

import com.xuefei.bean.Department;
import com.xuefei.bean.DepartmentExample;
import com.xuefei.mapper.DepartmentMapper;
import com.xuefei.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    @Transactional
    public Department findDepartmentById(String id) {
        Department department = departmentMapper.selectByPrimaryKey(id);
        return department;
    }

    @Override
    @Transactional
    public List<Department> findAllDepartments() {
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }

    @Override
    @Transactional
    public List<Department> findDepartmentByName(String name) {
        DepartmentExample departmentExample= new DepartmentExample();
        departmentExample.createCriteria().andNameLike("%"+name+"%");
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    @Override
    @Transactional
    public List<Department> findDepartmentByMobile(String mobile) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andTelephoneLike("%"+mobile+"%");
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    @Override
    public List<Department> findDepartmentByArea(String area) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andAreaLike("%"+area+"%");
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    @Override
    @Transactional
    public int saveDepartment(Department department) {
        int insert = departmentMapper.insert(department);
        return insert;
    }

    @Override
    @Transactional
    public int deleteDepartment(String id) {
        int i = departmentMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    @Transactional
    public int updateDepartment(Department department) {
        int i = departmentMapper.updateByPrimaryKeySelective(department);
        return i;
    }

    @Override
    @Transactional
    public int deleteBatch(List<String> ids) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andIdIn(ids);
        int i = departmentMapper.deleteByExample(departmentExample);
        return i;
    }
}
