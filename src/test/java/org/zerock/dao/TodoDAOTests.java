/*DAO를 작성하면 항상 테스트 코드를 이용해서 동작에 문제가 없는지를 확인하는것이 좋다*/

package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert()throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("Sample title...")
                .dueDate(LocalDate.of(2021,12,31))
                .build();

        todoDAO.insert(todoVO);
    }
}

/*TodoDATOTests 는 @BeforeEach를 이용하는 ready()를 통해서 모든 테스트전에 TodoDAO타입의 객체를 생성하도록 하고, testTime()을 이용해서
* TodoDAO에 작성한 getTime()이 정상 작동하는지를 확인한다.*/
