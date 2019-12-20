package com.xuefei.test;

import com.xuefei.mapper.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void testCRUD() {
        System.out.println(departmentMapper);
    }

}
