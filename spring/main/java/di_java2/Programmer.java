package di_java2;

import org.springframework.stereotype.Component;

@Component
public class Programmer implements Developer {

	@Override
	public void gotoOffice() {
		System.out.println("프로그래머 출근합니다");
	}

	@Override
	public void getoffOffice() {
		System.out.println("프로그래머 퇴근합니다");
	}

}
