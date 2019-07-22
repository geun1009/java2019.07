package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class helloMain {
	public static void main(String[] args) {
		//ApplicationContext 읽는 순간 객체가 두두두두 만들어짐
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("beanContainer.xml");
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml");
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:beanContainer.xml");
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:beanContainer.xml");
		
		
		//Hello obj = new Hello();
		Hello obj = (Hello)ctx.getBean("hello");
		System.out.println("obj : "+obj);
		//obj를 수정해도 obj2도 영향을 받음 같은 주소값
		Hello obj2 = (Hello)ctx.getBean("hello");
		System.out.println("obj : "+obj2);
	}
}
