package di_test;

public class Calculator {

    public void addition(int firstNum, int secondNum){
    	System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
    }

    public void substraction(int firstNum, int secondNum){
    	System.out.printf("%d - %d = %d\n", firstNum, secondNum, firstNum - secondNum);
    }

    public void multiplication(int firstNum, int secondNum){
    	System.out.println(firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
    }

    public void division(int firstNum, int secondNum){
    	System.out.println(firstNum + " / " + secondNum + " = " + (firstNum / secondNum));
    }

}
