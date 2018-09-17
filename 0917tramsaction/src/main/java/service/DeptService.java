package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DeptMapper;
import vo.Dept;

@Service
public class DeptService {
@Autowired
private DeptMapper deptMapper;

	
	//데이터를 삽입하는 메소드
	@Transactional
	public void insertdapt() {
		Dept dept = new Dept();
		dept.setDeptno(13);
		dept.setDname("영업");
		dept.setLoc("부산");
		
		deptMapper.insertDept(dept);
		deptMapper.insertDept(dept);
	}
}
