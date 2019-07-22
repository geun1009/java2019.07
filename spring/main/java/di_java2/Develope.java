package di_java2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Develope {

	@Autowired
	@Qualifier("programmer")
	private Developer developer;
	
	public void coding() {
		developer.gotoOffice();
		System.out.println("개발합니다");
		developer.getoffOffice();
	}
}
