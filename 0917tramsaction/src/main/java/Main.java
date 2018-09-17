import org.springframework.context.support.GenericXmlApplicationContext;

import service.DeptService;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		DeptService deptservice = context.getBean(DeptService.class);
		deptservice.insertdapt();
		
		context.close();

	}

}
