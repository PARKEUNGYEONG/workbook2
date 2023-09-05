package org.zerock.jdbcex.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString

/*VO는 주로 읽기 전용으로 사용하는 경우가 많으로 @Getter을 추가했고
* 객체 생성 시에 빌ㄷ러 패턴을 사용하기 위해서 @Builder 어노테이션을 추가하였다. */

public class TodoVO {

    private Long tno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;
}
