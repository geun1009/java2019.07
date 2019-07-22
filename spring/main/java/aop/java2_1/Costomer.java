package aop.java2_1;

import org.springframework.stereotype.Component;

public class Costomer implements Person {
	private int age;
	public Costomer() {}
	
	
	@Override
	public void setAge(int age) {
		System.out.println(age + "세로 설정 되었습니다");
		this.age=age;
	}
}
