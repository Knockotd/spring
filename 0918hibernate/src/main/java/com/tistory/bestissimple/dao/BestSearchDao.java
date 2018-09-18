package com.tistory.bestissimple.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.bestissimple.domain.BestSearch;

//bean을 자동으로 만들어주는 어노테이션
@Repository
public class BestSearchDao {

	
	//동일한 자료형의 bean이 있는 경우 자동으로 주입받는 설정
	@Autowired
	//hibernate를 사용하기 위한 인스턴스 변수
	private SessionFactory sessionFactory;
	
	//메소드에서 예외가 발생하면 rollback 되고
	//예외가 발생하지 않으면 commit 되도록 해주는 어노테이션
	@Transactional
	//데이터를 삽입하는 메소드
	public void insertBestSearch(BestSearch bestSearch) {
		sessionFactory.getCurrentSession().save(bestSearch);
	}
	@Transactional
	//데이터를 수정하는 메소드
	public void updateBestSearch(BestSearch bestSearch) {
		sessionFactory.getCurrentSession().update(bestSearch);
		}
	
	@Transactional
	//데이터를 삭제하는 메소드
	public void deleteBestSearch(BestSearch bestSearch) {
		sessionFactory.getCurrentSession().delete(bestSearch);
		}
	
	@Transactional
	//전체 데이터를 조회하는 메소드
	public List<BestSearch> allDataBestSearch() {
		//<BestSearch>없이 그냥 List로 리턴받을 수 있다.그러면 아래 코드도 형변환 없이 쓸 수 있지만, 어떤 자료형으로 리턴되는지 모르기 때문에 보기 좋으라고 이렇게 작성하는것이다.
		return (List<BestSearch>)sessionFactory.getCurrentSession().createCriteria(BestSearch.class).list();
		}
	
	@Transactional
	//num으로 데이터를 조회하는 메소드
	public BestSearch oneDataBeatSearch(int num) {
		return (BestSearch)sessionFactory.getCurrentSession().get(BestSearch.class, num);
	}
	
}
