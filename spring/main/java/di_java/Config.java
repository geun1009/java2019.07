package di_java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages= {"di_java"})
@Configuration
public class Config {

	/*
//	@Bean(name="hanTire")
	@Bean
	@Qualifier("hanTire")
	public Tire hankookTire() {
		return new HankookTire();
	}
	
	@Bean(name="kumTire")
	public Tire kumhoTire() {
		return new KumhoTire();
	}
	
	@Bean
	public Car car() {
		return new Car();
	}
	*/
}
//***  XML을 대체할 방법중 하나









