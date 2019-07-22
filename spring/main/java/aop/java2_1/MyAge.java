package aop.java2_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAge {

	@Before("execution(* aop.java2_1.*.setAge(..))")
	public void myAge(JoinPoint joinPoint) {

		Object[] tmp = joinPoint.getArgs();
		Integer age = (Integer) tmp[0];

		if (age < 20) {
			System.out.println("미성년자입니다.");
		} else {
			System.out.println("성인입니다.");
		}

	}
}