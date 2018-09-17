import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.tistory.bestissimple.dao.PersonDao;
import com.tistory.bestissimple.mybatis.domain.PersonVO;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		PersonDao dao = context.getBean(PersonDao.class);
		
		/*
		List<PersonVO> list = dao.personList();
		for(PersonVO person : list) {
			System.out.println(person);
		}
		*/
		
		//id를 가지고 데이터를 조회하는 메소드 호출
		PersonVO vo = dao.selectPerson("parkbogum");
		System.out.println(vo);
		vo = dao.selectPerson("sugangjun");
		System.out.println(vo);
		
		
		/*
		//프라이머리 키를 입력받을 때는 반드시 중복체크를 해야함.
		Scanner sc = new Scanner(System.in);
		String id = "";
		while(true) {
			System.out.print("사용할 id를 입력하세요.");
			id = sc.nextLine();
			vo = dao.selectPerson(id);
			
			if(vo == null) {
				break;
			}else {
				System.out.println(id + "는 중복으로 사용할 수 없는 id입니다.");
			}
		}
		
		System.out.print("비밀번호 입력:");
		String pw = sc.nextLine();
		
		System.out.print("이름 입력:");
		String name = sc.nextLine();
		
		System.out.println("전화번호 입력:");
		String phone = sc.nextLine();
		
		PersonVO inputVO = new PersonVO();
		inputVO.setId(id);
		inputVO.setPw(pw);
		inputVO.setName(name);
		inputVO.setPhone(phone);
		
		
		//select 이외의 구문은 영향받은 행의 개수를 리턴
		int result = dao.insertPerson(inputVO);
		System.out.println(result);
		sc.close();
		context.close();
		*/
		//프라이머리 키를 입력받을 때는 반드시 중복체크를 해야함.
				Scanner sc = new Scanner(System.in);
				String id = "";
				while(true) {
					System.out.print("사용할 id를 입력하세요.");
					id = sc.nextLine();
					vo = dao.selectPerson(id);
					
					if(vo == null) {
						break;
					}else {
						System.out.println(id + "는 중복으로 사용할 수 없는 id입니다.");
					}
				}
				
				System.out.print("비밀번호 입력:");
				String pw = sc.nextLine();
				
				System.out.print("이름 입력:");
				String name = sc.nextLine();
				
				System.out.println("전화번호 입력:");
				String phone = sc.nextLine();
				
				PersonVO inputVO = new PersonVO();
				inputVO.setId(id);
				inputVO.setPw(pw);
				inputVO.setName(name);
				inputVO.setPhone(phone);
				
				
				//select 이외의 구문은 영향받은 행의 개수를 리턴
				int result = dao.insertprocedure(inputVO);
				System.out.println(result);
				sc.close();
				context.close();
		
	}

}
