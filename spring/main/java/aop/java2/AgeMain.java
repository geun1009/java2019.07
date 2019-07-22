package aop.java2;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AgeMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Person c = (Person)context.getBean("costomer");
		Scanner sc= new Scanner(System.in);
		int age;
		System.out.print("나이 입력 : ");
		age = sc.nextInt();
		
		c.setAge(age);
	}
}
