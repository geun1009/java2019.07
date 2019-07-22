package aop.xml;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	public void gotoOffice(JoinPoint joinPoint) {
		System.out.println("출근 합니다....");
	}
	
	public void getoffOffice() {
		System.out.println("퇴근을 합니다...");
	}
}
