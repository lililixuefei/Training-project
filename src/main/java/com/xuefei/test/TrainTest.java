package com.xuefei.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.proxy.DruidDriver;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TrainTest {

    DruidDataSource druidDataSource = new DruidDataSource();

    @Test
    public void test() throws SQLException {
        System.out.println(druidDataSource);
    }

}
