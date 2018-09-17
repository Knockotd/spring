package com.tistory.bestissimple.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tistory.bestissimple.mybatis.domain.PersonVO;

public interface PersonInterface {
	//person 테이블의 모든 데이터를 가져오는 메소드
	@Select("select * from person")
	public List<PersonVO> allview();
	
	//person 테이블에서 id가 일치하는 데이터 1개를 가져오는 메소드
	@Select("select * from person where id=#{id}")
	public PersonVO oneview(String id);
}
