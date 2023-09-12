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

    @Test
    public void testSelectOne() throws Exception{

        Long tno = 1L;//반드시 존재하는 번호를 이용

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);
    }

    //여러개의 데이터가 나오는 selctAll()과 달리 selectOne()은 한 행의 데이터만 나오기 때문에 한번단 resultSet.next()을 실행하면 된다.

}


