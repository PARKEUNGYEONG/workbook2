package org.zerock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConnectTests {
    //ConnectTests 에는@Test어노테이션을 사용하는 메소드를 작성한다.이를 테스트 코드라고 한다.
    @Test
    public void test1(){
        int v1 =10;
        int v2 =10;

        Assertions.assertEquals(v1,v2);
        //Assertions.assertEquals() = 같다고 확신한다는 의미, 두 변수의 내용이 같아야만 테스트가 성공.

    }
    }

