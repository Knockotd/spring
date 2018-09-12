import java.util.List;

import dao.GoodDao;
import dao.GoodDaoFactory;
import vo.GoodVO;

public class Main {

	public static void main(String[] args) {
		//GoodDao 인스턴스 생성
		GoodDao dao = GoodDaoFactory.create();
		System.out.println(dao.hashCode());
		//필요한 메소드 호출
		List<GoodVO> list = dao.getGood();
		//메소드 호출 결과 출력
		for(GoodVO vo : list) {
			System.out.println(vo);
		}
		dao = GoodDaoFactory.create();
		System.out.println(dao.hashCode());
		
	}

}
