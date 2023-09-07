package org.zerock.jdbcex.dao;

import lombok.Cleanup;
import org.zerock.jdbcex.domain.TodoVO;

import java.sql.Connection;
import java.sql.Date;
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
    public void insert(TodoVO vo)throws Exception{
        String sql = "insert into tbl_todo (title,dueDate,finished)values(?,?,?)";
        /*insert()는 파라미터로 입력된 TOdoVO객체의 정보를 이용해서 DML을 실행하기 떄문에 excuteUpdate를 실행하도록 구성한다,*/

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(3,vo.isFinished());

        preparedStatement.executeUpdate();
        /*preparedStatement는 ?를 이용해서 나중에 전달할 데이터들을 지정하는데 setXXX()을 이용해서 실제 값들을 지정한다.
        * 이떄 인덱스 번호가 0이 아닌 1부터 시작된다는것을 주의해야한다. 예제의 경우 3개의 ?가 존재하므로 setXXX()역시 3개를 지정해야한다. */
    }


}

/*getTime()은 try-with-resources 기능을 이용해서 try()내에 선언된 변수들이 자동으로 close()될 수 있는 구조로 작성*/
