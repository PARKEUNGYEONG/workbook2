/*DAO를 작성하면 항상 테스트 코드를 이용해서 동작에 문제가 없는지를 확인하는것이 좋다*/

package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        //빌더 패턴은 생성자와 달리 필요한 만큼만 데이터를 세팅할수 있다는 장점이 있다.
    }

    @Test
    public void testList() throws Exception{
        List<TodoVO> list = todoDAO.selectAll();

       list.forEach(vo->System.out.println(vo));
    }

}


