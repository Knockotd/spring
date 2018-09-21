package tistory.simpleisbest.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tistory.simpleisbest.view.domain.DataReport;
import tistory.simpleisbest.view.domain.DataStructure;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	//excel.xls 요청을 처리하는 메소드
	@RequestMapping(value="excel.xls", method=RequestMethod.GET)
	public String excel(Model model) {
		//1.7이상에서만 아래 형태로 사용 가능
		//그 이하 버전에는 반드시 <>안에 자료형 기재
		List<String> list = new ArrayList<>();
		list.add("엑셀로 출력하는 걸 데이터 베이스 연동해서 해보");
		list.add("spring 처음부터 다시 공부하기");
		list.add("socket 부분이 약한 것 같으니 더 파고들어 공부하기");
		list.add("메일보내기 안 되던거 해결하기");
		list.add("포트폴리오로 프로젝트 만들기");
		list.add("스트림 조금 더 정리하기");
		list.add("메모 자료 내껄로 만들어서 블로그에 올리기");
		model.addAttribute("list", list);
		return "dolist";
	}
	
	//data.pdf 요청을 처리하는 메소드
	@RequestMapping(value="data.pdf", method=RequestMethod.GET)
	public String pdf(Model model) {
		List<String> list = new ArrayList<>();
		list.add("Oracle-RDBMS");
		list.add("MS-SQL-RDBMS");
		list.add("MySQL(MariaDB)-RDBMS");
		list.add("ACCESS-RDBMS");
		list.add("Sqllite-RDBMS");
		list.add("MongoDB-NoSQL");
		list.add("Cassandra-NoSQL");
		
		//db라는 이름으로 list를 저장
		model.addAttribute("db", list);
		
		//출력하는 뷰 이름을 db로 설정
		return "db";
	}
	
	@RequestMapping(value="jsonview.json", method=RequestMethod.GET)
	public String json(Model model) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("name", "박보검");
		map.put("age", "26");
		list.add(map);
		
		map=new HashMap<>();
		map.put("name","송민호" );
		map.put("age", "26");
		list.add(map);
		
		map=new HashMap<>();
		map.put("name","서강준" );
		map.put("age", "26");
		list.add(map);
		
		model.addAttribute("list",list);
		
		return "jsonview";
	}
	
	@RequestMapping(value="data.xml", method=RequestMethod.GET)
	public String data(Model model) {
		DataStructure ds1 = new DataStructure();
		ds1.setKind("coffee");
		ds1.setName("아메리카노");
		ds1.setPrice(1500);
		
		DataStructure ds2 = new DataStructure();
		ds2.setKind("coffee");
		ds2.setName("카페라떼");
		ds2.setPrice(3500);
		
		DataStructure ds3 = new DataStructure();
		ds3.setKind("tea");
		ds3.setName("얼그레이");
		ds3.setPrice(3500);
		
		List<DataStructure> list = new ArrayList<>();
		list.add(ds1);
		list.add(ds2);
		list.add(ds3);
		
		DataReport dr = new DataReport();
		dr.setList(list);
		
		//위 데이터를 모델에 저장
		model.addAttribute("dataReport", dr);
		
		//출력할 뷰 이름을 리턴
		return "dataxml";
	}
}
