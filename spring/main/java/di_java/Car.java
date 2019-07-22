package di_java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	//@Resource(name="kumTire")
	@Autowired @Qualifier("hanTire")
	private Tire tire;

	// 기본생성자 : alt + shift + s 누른후 c 선택
	public Car() {
		System.out.println("Car() 호출...");
	}
	
	//@Autowired
	public Car(/*@Qualifier("kumTire")*/Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire) 호출...");
	}
	

	//@Autowired
	//@Qualifier("hanTire")
	
	//@Resource
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire() 호출...");
	}


	public String getTireBrand() {
		return tire.getBrand();
	}
	
}
