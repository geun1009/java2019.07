package aop.java;

/*
 * SPRING AOP 특징
 * 1. PROXY 기반
 * 2. 런타임 기반
 * 3. 인터페이스 기반
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Employee e = context.getBean("designer", Employee.class);
		e.work();
	}
}
