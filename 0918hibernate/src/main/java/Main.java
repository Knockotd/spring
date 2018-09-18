import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.tistory.bestissimple.dao.BestSearchDao;
import com.tistory.bestissimple.domain.BestSearch;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		BestSearchDao dao = context.getBean(BestSearchDao.class);
		
		List<BestSearch> list = dao.allDataBestSearch();
		
		for(BestSearch imsi : list) {
			System.out.println(imsi);
		}
		
		//데이터 1개 가져오기
		System.out.println(dao.oneDataBeatSearch(4));
		
	}

}
