package vo;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//스프링 설정 파일의 내용 가져오기
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		System.out.println(1);
		
		//fruit 이라는 id를 가진 객체 가져오기
		FruitVO fruit = context.getBean("fruit", FruitVO.class);
		System.out.println(2);
		System.out.println(fruit);
		System.out.println(3);
		context.close();
	}

}
