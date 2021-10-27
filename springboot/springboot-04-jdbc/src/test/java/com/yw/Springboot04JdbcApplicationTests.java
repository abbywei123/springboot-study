package com.yw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04JdbcApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看数据源 class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

        //获取数据库连接
        Connection connection=dataSource.getConnection();
        //HikariProxyConnection@231995562 wrapping com.mysql.cj.jdbc.ConnectionImpl@3d615b2e
        System.out.println(connection);

        //关闭
        connection.close();


    }

}
