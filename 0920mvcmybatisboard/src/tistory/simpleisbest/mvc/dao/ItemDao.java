package tistory.simpleisbest.mvc.dao;

import java.util.List;

import tistory.simpleisbest.mvc.domain.Item;

public interface ItemDao {
//전체 데이터를 가져오는 메소드
	public List<Item> ListItem();
	
	//상세보기를 위한 메소드
			public Item getItem(int itemid);
}
