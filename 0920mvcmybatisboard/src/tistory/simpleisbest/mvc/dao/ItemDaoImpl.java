package tistory.simpleisbest.mvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tistory.simpleisbest.mvc.domain.Item;
@Repository
public class ItemDaoImpl implements ItemDao {

	
	//MyBatis 실행 객체를 주입
	@Autowired
	private SqlSession sqlSession;


	public List<Item> ListItem() {
		//	전체 데이터 가져오는 메소드
		return sqlSession.selectList("item.item");
	}


	public Item getItem(int itemid) {
		
		return sqlSession.selectOne("item.getitem", itemid);
	}

}
