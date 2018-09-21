package tistory.simpleisbest.aop;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tistory.simpleisbest.aop.domain.Command;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value="interceptor", method=RequestMethod.GET)
	public String interceptor() {
		System.out.println("컨드롤러 도착");
		
		int sum = 0;
		for(int i=1; i<=100000000; i=i+1) {
			sum=sum+i;
		}
		return "";
	}
	
	@RequestMapping(value="fileupload", method=RequestMethod.GET)
	public String fileupload(Model model) {
		
		return "fileupload";
	}
	
	@RequestMapping(value="fileupload", method=RequestMethod.POST)
	public String fileupload(Command command, Model model) {
		System.out.println("이름:"+command.getName());
	if(command.getReport().isEmpty()) {
		System.out.println("첨부파일이 없습니다.");
	}else {
		//업로드 할 디렉토리 이름 설정
		String uploadPath="/Users/a503-26/Desktop/";
		
		//파일 경로 만들기
		String filepath = uploadPath+UUID.randomUUID()+command.getReport().getOriginalFilename();
		//파일 업로드
		try {
			command.getReport().transferTo(new File(filepath));
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("파일업로드 성공");
	}
	//변화를 주는 작업을 수행하면 반드시 리다이렉트를 해야 합니다.
		return "redirect:./";
	}
}
