package tistory.bestissimple.mvc;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tistory.bestissimple.mvc.vo.Article;

@Controller
public class HomeController {
	//시작 요청이 왔을 때 처리하는 메소드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	// input 요청이 왔을 때 처리
	@RequestMapping(value="param/input", method=RequestMethod.GET)
	public String paramInput(Model model) {
		//여기서 리턴한 뷰 이름을 가지고 servlet-context.xml 파일의 ViewResolver와 결합해서 실제 출력할 파일이 결정 됨.
		return "param/input";
	}
	/*
	 * HttpServletRequest 이용한 파라미터 처리(기존과 동일)
	@RequestMapping(value="param/input",method=RequestMethod.POST)
	//java web 프로그래밍에서 제공하는 request 객체를 이용해서 파라미터 읽기
	public String input(HttpServletRequest request, Model model) {
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println("제목: "+subject);
		System.out.println("내용: "+content);
		return "";
	}
	*/
	/*
	//@RequestParam을 이용한 파라미터 처리
	@RequestMapping(value="param/input", method=RequestMethod.POST)
	public String a (
			@RequestParam("subject")String subject,
			@RequestParam("content")String content,
			Model model) {
			System.out.println("제목: "+subject);
			System.out.println("내용: "+content);
		return "출력할 뷰 이름";
	}
	*/
	
	//Command 객체를 이용한 파라미터 처리
	@RequestMapping(value="param/input", method=RequestMethod.POST)
	public String i (Article article, Model model, HttpSession session, RedirectAttributes attr) {
		
		//request에 저장됩니다. : 한번만 전송 : 포워딩할 때만 됨.
		model.addAttribute("client","web browser");
		//계속 저장 - 임베디드 & 리무브 해야 사라짐 : 포워딩과 리다이렉트 둘 다 됨.
		session.setAttribute("server", "Java - Spring");
		
		//세션에 저장되는데 한 번 사용하면 삭제 됨. : 리다이렉트 해야함 
		//리다이렉트 할 때만 전달 됩니다.
		attr.addFlashAttribute("db","Oracle");
		
		System.out.println(article);
		//param/result로 포워딩
		
		//result로 리다이렉트 - model 데이터는 전송되지 않음
		return "redirect:result";
	}
	//result 요청이 왔을 때 처리하는 메소드
	@RequestMapping(value="param/result", method=RequestMethod.GET)
	public String b(Model model) {
		return "param/result";
	}
	
}
