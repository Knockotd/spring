import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.tistory.bestissimple.dao.PersonInterface;
import com.tistory.bestissimple.mybatis.domain.PersonVO;

public class InterfaceMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		
		//매퍼 인터페이스를 구현한 객체 찾아오기
		PersonInterface pi = context.getBean(PersonInterface.class);
		
		List<PersonVO> list = pi.allview();
		for(PersonVO vo : list) {
			System.out.println(vo);
		}
		
		PersonVO oneView = pi.oneview("samdi");
		System.out.println(oneView);
				
	}
	

}
