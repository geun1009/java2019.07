package di_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalMain3 {

    public static void main(String[] args){
    	
    	ApplicationContext context = new GenericXmlApplicationContext("di_test/beanCtx3.xml");
    	
    	MyCalculator myCalculator = context.getBean("myCalculator", MyCalculator.class);
    	
   
    	myCalculator.add();
    	myCalculator.sub();
    	myCalculator.mul();
    	myCalculator.div();
    	
    }

}
