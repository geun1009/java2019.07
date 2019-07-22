package aop.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
public class MyAspect {
	@Before("excution(* work()")
	public void gotoOffice(JoinPoint joinPoint) {
		System.out.println("출근 합니다....");
	}
	
	@After("excution(* aop.anno.*.work()")
	public void getoffOffice() {
		System.out.println("퇴근을 합니다...");
	}
}
