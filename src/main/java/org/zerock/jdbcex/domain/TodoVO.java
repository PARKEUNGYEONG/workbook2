package org.zerock.jdbcex.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString

/*VO는 주로 읽기 전용으로 사용하는 경우가 많으로 @Getter을 추가했고
* 객체 생성 시에 빌더 패턴을 사용하기 위해서 @Builder 어노테이션을 추가하였다. */

//객체지향 프로그램에서는 데이터를 객체라는 단위로 처리한다.
//데이터베이스에서는 하나의 데이터를 엔티티라고 하는데 자바 프로그램에서는 이를 처리하기 위해서 테이블과 유사한 구조의 클래스를 만들어서 객체로 처리하는 방식을 사용한다.  이때 만든 객체는 '값을 보관하는 용도'라는 의미에서 VO(Value Object)라고 한다.
//VO는  DTO와 유사한 모습이지만 DTO가 각 계층을 오고 가는데 사용되는 택배 상자와 비슷하다면 VO는 데이터베이스의 엔티티를 자바 객체로 표현한 것이라고 생각할 수 있다.
//DTO는 getter/setter를 이용해서 자유롭게 데이터를 가공할 수 있는데 비해 VO는 주로 데이터 자체를 의미하기 때문에 getter만을 이용하는 경우가 대부분이다.

public class TodoVO {

    private Long tno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;
}
