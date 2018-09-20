package tistory.simpleisbest.mvc.service;

import java.util.List;

import tistory.simpleisbest.mvc.domain.Item;

public interface ItemService {

	//전체데이터를 가져오는 메소드
	//파라미터가 없으면 Dao 메소드와 동일한 구조입니다.
	public List<Item> listItem();
	
	//itemid를 가지고 하나의 데이터를 찾아오는 메소드
	public Item getItem(int itemid);
}
