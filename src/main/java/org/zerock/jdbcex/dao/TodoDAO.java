package org.zerock.jdbcex.dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {

    public String getTime() {
        String now = null;

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            resultSet.next();

            now = resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public String getTIme2() throws Exception{

        /*@Cleanup 을 이용하면 Lombok 라이브러리에 상당히 종송적인 코드를 작성하게 된다는 부담이 있기는 하지만
        * 최소한의 코드로 close()가 보장되는 코드를 작성할 수 있다는 장점이 있다.*/
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }

}

/*getTime()은 try-with-resources 기능을 이용해서 try()내에 선언된 변수들이 자동으로 close()될 수 있는 구조로 작성*/
