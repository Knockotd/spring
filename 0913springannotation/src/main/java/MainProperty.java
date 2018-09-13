import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainProperty {

	public static void main(String[] args) {
		//시스템 프로퍼티를 읽을 수 있는 객체를 생성
		AnnotationConfigApplicationContext
		context = new AnnotationConfigApplicationContext();
		
		ConfigurableEnvironment env
		= context.getEnvironment();
		System.out.println("Path:"+env.getProperty("Path"));
		//usr/bin은 아주 기본적인 경로이다.
		System.out.println("Java Version:"+env.getProperty("java.version"));
		System.out.println("OS Name:"+env.getProperty("os.version"));
		try {
			//프로퍼티 파일을 추가할 수 있는 객체 가져오기
		MutablePropertySources source =
				env.getPropertySources();
		//프로퍼티 파일의 경로 추가
		source.addLast(new ResourcePropertySource("classpath:db.properties"));
		//추가된 프로퍼티 파일의 내용 읽기
		System.out.println(env.getProperty("url"));
		System.out.println(env.getProperty("name"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		context.close();
	}

}
