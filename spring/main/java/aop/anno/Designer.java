package aop.anno;

public class Designer implements Employee {

	@Override
	public void work() {
		System.out.println("디자인 합니다");
	}

}
