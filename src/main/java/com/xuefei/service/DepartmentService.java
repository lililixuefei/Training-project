package com.xuefei.service;

import com.xuefei.bean.Department;
import com.xuefei.bean.Patient;

import java.util.List;

public interface DepartmentService {

    public Department findDepartmentById(String id);

    public List<Department> findAllDepartments();

    public List<Department> findDepartmentByName(String name);

    public List<Department> findDepartmentByMobile(String mobile);

    public List<Department> findDepartmentByArea(String area);

    public int saveDepartment(Department department);

    public int deleteDepartment(String id);

    public int updateDepartment(Department department);

    public int deleteBatch(List<String> ids);


}
