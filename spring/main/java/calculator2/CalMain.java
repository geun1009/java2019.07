package calculator2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalMain {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("cal2.xml");

		MyCalculator c = context.getBean("cal", MyCalculator.class);

		c.add();
		c.sub();
		c.mul();
		c.div();
	}
}
