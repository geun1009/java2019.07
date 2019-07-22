package di_test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class MyCalculator {
	
	@Value("17")
    private int firstNum;
	@Value("6")
    private int secondNum;
    @Autowired
    private Calculator calculator;
    
    public MyCalculator() {
	}
    
	public MyCalculator(Calculator calculator) {
		super();
		this.calculator = calculator;
	}

	public MyCalculator(int firstNum, int secondNum, Calculator calculator) {
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

	public void setFirstNum( int firstNum) {
		this.firstNum = firstNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	@Autowired
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}



}


