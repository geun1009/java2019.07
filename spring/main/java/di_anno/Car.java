package di_anno;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
	//@Autowired
	//@Qualifier("hanTire")
	//@Autowired(required = false)
	@Resource(name="kumTire")
	private Tire tire;

	// 기본생성자 : alt + shift + s 누른후 c 선택
	public Car() {
		System.out.println("Car() 호출...");
	}

	//@Autowired//타입이 먼저
	//@Resource//이름 매칭후 타입 매칭
	public Car(/*@Qualifier("kumTire")*/Tire tire) {//한국 금호 타이어가 있는데 tire, kumTire일 경우 tire가 들어간다.이름으로 매칭
		this.tire = tire;
		System.out.println("Car(Tire) 호출...");
	}
	

	//@Autowired
	//@Qualifier("hanTire")
	@Resource
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire() 호출...");
	}


	public String getTireBrand() {
		return tire.getBrand();
	}
	
}
