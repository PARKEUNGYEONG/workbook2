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
    public void testConnection() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        // Class.forName() : jdbc 드라이버 클래스를 메모리상으로 로딩하는 역할을 한다.

        Connection connection =DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/webdb",
                "webuser",
                "webuser"
        );
        /* Connection connection : java.sql 패키지의 connection 인터페이스 타입의 변수
         * DriverManager.getConnection : 데이터베이스 내에 있는 여러 정보들을 통해서 특정한 데이터베이스(예제에서는 webdb)에 연결을 시도
         * "jdbc:mysql://localhost:3306/webdb" : jdbc 프로토콜을 이용한다는 의미. localhost:3306는 네이트워크 연결정보. webdb는 연결하려는 데이터베이스의 정보
         *  */

        Assertions.assertNotNull(connection);
        /*Assertions.assertNotNull(connection) : 데이터베이스와 정상적으로 연결이 된다면 connction 타입의 객체는 null이 아니라는것을 확신한다는 의미.*/

        connection.close();
        /*connection.close() : 데이터베이스와 연결을 종료. jdbc프로그램은 데이터베이스와 연결을 잠깐식 맺고 종료하는 방식으로 처리된다.
         * 따라서 반드시 작업이 완료되면 데이터베이스와의 연결을 종료해주어야만 한다. */
    }


    @Test
    public void testHikariCP() throws Exception {

        HikariConfig config = new HikariConfig();

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("preStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();


    }

}

