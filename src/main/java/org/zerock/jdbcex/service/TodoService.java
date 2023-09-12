//DTO와 VO를 둘다 이요하는 패키지
//TodoService 는 ModelMapper와 TodoDAO를 이용할 수 있도록 구성,새로운 TodoDTO를 등록하는 기능을 추가
package org.zerock.jdbcex.service;

import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService(){
        dao=new TodoDAO();
        modelMapper =MapperUtil.INSTANCE.get();
    }


}
