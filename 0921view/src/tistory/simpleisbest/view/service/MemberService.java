package tistory.simpleisbest.view.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tistory.simpleisbest.view.MemberDao;

@Service
public class MemberService {
@Autowired
private MemberDao dao;

public String idcheck(String id) {
	return dao.idcheck(id);
}
}
