package di_xml;

public class Car {
	private Tire tire;
	private Tire spareTire;
	
	// 기본생성자 : alt + shift + s 누른후 c 선택
	public Car() {
		System.out.println("Car() 호출...");
	}

	// 매개변수생성자 : alt + shift + s 누른후 o 선택
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire) 호출...");
	}
	
	public Car(Tire tire, Tire spareTire) {
		this.tire = tire;
		this.spareTire = spareTire;
		System.out.println("Car(Tire, Tire) 호출...");
	}
	
	public Car(Tire tire, Tire spareTire, int num) {
		this.tire = tire;
		this.spareTire = spareTire;
		System.out.println("Car(Tire, Tire, int) 호출..." + num);
	}

	// setter/getter : alt + shift + s 누른후 r 선택
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire() 호출...");
	}

	public void setSpareTire(Tire spareTire) {
		this.spareTire = spareTire;
		System.out.println("setSpareTire() 호출...");
	}

	public String getTireBrand() {
		return tire.getBrand();
	}
	
	public String getSpareTireBrand() {
		return spareTire != null ? spareTire.getBrand() : "미장착";
	}
}
