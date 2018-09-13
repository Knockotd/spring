import org.springframework.context.support.GenericXmlApplicationContext;

import com.tistory.bestissimple.controller.SampleController;
import com.tistory.bestissimple.dao.SampleDao;
import com.tistory.bestissimple.service.SampleService;

public class Main {

	public static void main(String[] args) {

			GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(
					"classpath:applicationContext.xml");
			
			SampleDao dao = 
				context.getBean(SampleDao.class);
			System.out.println(dao.test());
			
			SampleService sevice = context.getBean(SampleService.class);
			System.out.println(sevice.test());
			
			SampleController controller = context.getBean(SampleController.class);
			System.out.println(controller.test());
			
			context.close();
	}

}
