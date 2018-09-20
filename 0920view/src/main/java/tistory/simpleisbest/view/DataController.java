package tistory.simpleisbest.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tistory.simpleisbest.view.service.MemberService;
//csv를 만들어서 리턴하는 메소드
@RestController
public class DataController {
	
	@Autowired
	private MemberService service;
	@RequestMapping(value="idcheck", method=RequestMethod.GET)
	//반드시 idcheck 요청을 할 때 id 의 값을 같이 넘겨주어야 합니다. @RequestParam("id") String id 이 태그가 있으면 반드시 id 를 넘겨주어야 합니다.
	public Map<String, String> idcheck(@RequestParam("id") String id){
		System.out.println("컨트롤러 도착");
		System.out.println(id);
		String result = service.idcheck(id);
		
		Map<String, String> map = new HashMap<>();
		if(result == null) {
			//아이디가 없을 때
			map.put("result", "true");
		}else {
			//아이디가 있을 
			map.put("result", "false");
		}
		System.out.println(result);
		System.out.println(map);
		return map; 
	}

	@RequestMapping(value="data.csv", method=RequestMethod.GET)
	public String dataCSV() {
		return "csv, xml, json";
	}
	//json을 만들어서 리턴하는 메소드
	@RequestMapping(value="data.json", method=RequestMethod.GET)
	public List<Map<String, Object>> dataJson(){
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "송민호");
		map.put("description", "바보인데 천재");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "김유정");
		map.put("description", "연기를 매우 잘 함");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "박보검");
		map.put("description", "착하지만 어딘가 많이 부족함");
		list.add(map);
		
		return list;
	}
}
