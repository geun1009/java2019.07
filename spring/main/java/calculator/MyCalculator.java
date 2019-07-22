package calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyCalculator {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("cal1.xml");

		Calculator c = context.getBean("cal", Calculator.class);
		/*
		c.add(15,4);
		c.sub(15,4);
		c.mul(15,4);
		c.div(15,4);
		*/
		
		
	}
}
