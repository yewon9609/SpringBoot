package com.example.ex01.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service    //인터페이스에는 service어노테이션을 붙여서 스프링 컨테이너에 빈으로 등록한다.
@Mapper     //마이바티스 연결 등록(xml id매핑) //보통 인터페이스를 mapper로 등록하기위해 사용하는 어노테이션이다.
public interface TimeMapper {

//    SQL이 복잡하거나 길어지는 경우에는 어노테이션보다는 XML을 이용하는 방식을 더 선호하게 된다.
//    MyBatis-Spring의 경우 Mapper인터페이스와 XML을 동시에 이용할 수 있따.
//    @Select("SELECT SYSDATE FROM DUAL") //간단한 sql은 어노테이션으로 작성 가능
    public String getTime();
}
