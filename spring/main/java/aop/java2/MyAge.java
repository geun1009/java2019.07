package aop.java2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;


public class MyAge {
	
	@Before("execution(* aop.java2.*.setAge(..))")
	public void age(JoinPoint joinPoint) {
		
		Object[] tmp = joinPoint.getArgs();
		Integer age = (Integer) tmp[0];
		
		if(age<20) {
			System.out.println("미성년자입니다.");
		}else {
			System.out.println("성인입니다.");
		}
			
	}
}