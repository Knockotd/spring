package com.tistory.bestissimple.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tistory.bestissimple.mybatis.domain.PersonVO;

//자동으로 bean을 생성해주는 어노테이션
//@Repository
public class PersonDao {
//동일한 자료형의 bean이 있으면 자동으로 주입받는 어노테이션
//@Autowired
private SqlSession sqlSession;

public List<PersonVO> personList() {
	//List로 리턴할 때에는 selectList를 사
	//""에는 sql 의 id를 적는다.
	return sqlSession.selectList("person.personlist");
}

//person 테이블에서 id를 가지고 하나의 데이터를 찾아오는 메소드
public PersonVO selectPerson(String id){
	//하나의 찾아오는 메소드 호출. 없으면 null리턴, 2개 이상이면 예외를 발생시킴
	return sqlSession.selectOne("person.selectperson", id);
}

//Person 테이블에 데이터를 삽입하는 메소드
public int insertPerson(PersonVO vo) {
	return sqlSession.insert("person.insertperson", vo);
}

//perso테이블에 데이터를 삽입하는 메소드
public int insertprocedure(PersonVO vo) {
	return sqlSession.insert("person.newinsertperson", vo);
}

}
