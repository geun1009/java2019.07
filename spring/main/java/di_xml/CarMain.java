package di_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di_xml.xml");
		
		Car car = (Car)context.getBean("car");	
			
		
		System.out.println("장착된 타이어 : " + car.getTireBrand());
		System.out.println("스페어 타이어 : " + car.getSpareTireBrand());
		
		//Car car2 = new Car(new HankookTire(), new KumhoTire());
		Car car2 = (Car)context.getBean("car2");
		System.out.println("장착된 타이어 : " + car2.getTireBrand());
		System.out.println("스페어 타이어 : " + car2.getSpareTireBrand());
	}
}
