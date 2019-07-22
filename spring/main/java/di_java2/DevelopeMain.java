package di_java2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DevelopeMain {

	public static void main(String[] args) {

//		ApplicationContext context = new GenericXmlApplicationContext("di_test4/beanCtx.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Develope develope = context.getBean("develope", Develope.class);
		develope.coding();
	}
}
