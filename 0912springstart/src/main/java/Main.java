import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.GoodDao;
import dao.GoodDaoFactory;
import vo.GoodVO;

public class Main {

	public static void main(String[] args) {
		// GoodDao 인스턴스 생성
		// GoodDao dao = new GoodDao();
		// GoodDao dao = GoodDaoFactory.create();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GoodDaoFactory.class);
		GoodDao dao = context.getBean("create", GoodDao.class);
		System.out.println(dao.hashCode());
		// 필요한 메소드 호출
		List<GoodVO> list = dao.getGood();
		// 메소드 호출 결과 출력
		for (GoodVO vo : list) {
			System.out.println(vo);
		}
		// dao = GoodDaoFactory.create();
		dao = context.getBean("create", GoodDao.class);
		System.out.println(dao.hashCode());

	}

}
