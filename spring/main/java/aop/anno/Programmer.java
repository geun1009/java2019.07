package aop.anno;

import org.springframework.stereotype.Component;


public class Programmer implements Employee {

	@Override
	public void work() {
		System.out.println("개발을 합니다");
	}

	
}
