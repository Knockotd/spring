package tistory.simpleisbest.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tistory.simpleisbest.mvc.dao.ItemDao;
import tistory.simpleisbest.mvc.domain.Item;
@Service
public class ItemServiceImpl implements ItemService {
@Autowired
private ItemDao itemDao;
	@Override
	//파라미터가 없는 경우는 Dao 메소드와 결과를 바로 리턴
	public List<Item> listItem() {
		return itemDao.ListItem();
	}
	@Override
	public Item getItem(int itemid) {
		
		return itemDao.getItem(itemid);
	}

}
