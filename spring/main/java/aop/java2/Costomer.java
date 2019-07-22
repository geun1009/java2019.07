package aop.java2;

import org.springframework.stereotype.Component;

@Component
public class Costomer implements Person {
	private int age;
	public Costomer() {System.out.println("기본생성자 생성");}
	
	

	@Override
	public void setAge(int age) {
		System.out.println(age + "세로 설정 되었습니다");
		
	}
}
