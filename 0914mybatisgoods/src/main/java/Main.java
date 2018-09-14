import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.tistory.bestissimple.dao.GoodDao;
import com.tistory.bestissimple.domain.Good;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		GoodDao dao = context.getBean(GoodDao.class);
		System.out.println(dao);
		System.out.println(dao.list());
		List<Good> list = dao.list();
		for(Good imsi : list) {
			System.out.println(imsi);
		}
		
		Good g = new Good();
		g.setCode(6);
		g.setName("용과");
		g.setPrice(3000);
		g.setDescription("하나에 3000원");
		dao.insertGood(g);
		System.out.println(dao.list());
		context.close();
	}

}
