import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import vo.CollectionBean;
import vo.Sample;

public class Main {

	public static void main(String[] args) {
		// 스프링 컨테이너 실행하기 - 컨테이너 안에 있는 Bean 의 객체가 전부 생성됩니다.
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"classpath:applicationContext.xml");
		// 생성된 객체 가져오기 - 아이디만 대입한 경우는 Object로 리턴되므로 강제 형 변환을 해서 사용
		//동일한 클래스로 만들어진 빈이 1개이면 아이디를 생략하고 클래스 이름만 대입해도 됩니다.
		Sample sample = context.getBean("sample", Sample.class);
		System.out.println(sample);
		
		
		//CollectionBean 객체 가져오기
		CollectionBean collectionBean =
				context.getBean(CollectionBean.class);
		for(String imsi : collectionBean.getList()) {
			System.out.println(imsi);
		}
		for(String imsi : collectionBean.getSet()) {
			System.out.println(imsi);
		}
		Set<String> keySet = collectionBean.getMap().keySet();
		for(String imsi : keySet) {
			System.out.println(imsi + ":" + collectionBean.getMap().get(imsi));
		}
		
		context.close();
	}

}
