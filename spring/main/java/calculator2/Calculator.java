package calculator2;

public class Calculator {

	public void add(int f, int s) {
		System.out.println("add,, " + f + " + " + s + " = " + (f+s));
	}

	public void sub(int f, int s) {
		System.out.println("sub,, " + f + " - " + s + " = " + (f-s));
	}

	public void mul(int f, int s) {
		int r = f * s;
		System.out.println("mul,, " + f + " x " + s + " = " + (f*s));
	}

	public void div(int f, int s) {
		System.out.println("div,, " + f + " % " + s + " = " + (f/(float)s));
	}

}
