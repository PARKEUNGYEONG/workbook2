package org.zerock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class ConnectTests {
    //ConnectTests 에는@Test어노테이션을 사용하는 메소드를 작성한다.이를 테스트 코드라고 한다.


    @Test
    public void testHikariCP() throws Exception {


        HikariConfig config = new HikariConfig("com.mysql.cj.jdbc.Driver");
        config.setDriverClassName("jdbc:mysql://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("preStntCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();


    }

}

