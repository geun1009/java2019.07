package di_test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class MyCalculator2 {
    private int firstNum;
    private int secondNum;
    private Calculator calculator;
    
    public MyCalculator2() {
	}
    
	public MyCalculator2(Calculator calculator) {
		super();
		this.calculator = calculator;
	}

	public MyCalculator2(int firstNum, int secondNum, Calculator calculator) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.calculator = calculator;
	}

	public void add(){
    	calculator.addition(firstNum, secondNum);
    }

    public void sub(){
    	calculator.substraction(firstNum, secondNum);
    }

    public void mul(){
    	calculator.multiplication(firstNum, secondNum);
    }

    public void div(){
    	calculator.division(firstNum, secondNum);
    }

    @Autowired
    @Value("13")
	public void setFirstNum( int firstNum) {
		this.firstNum = firstNum;
	}

    @Autowired
	public void setSecondNum(@Value("5") int secondNum) {
		this.secondNum = secondNum;
	}

	@Autowired
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}



}


