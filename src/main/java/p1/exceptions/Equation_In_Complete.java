package p1.exceptions;

public class Equation_In_Complete extends Exception{

	public Equation_In_Complete() {
		super("Expression should not end with operator");
		// TODO Auto-generated constructor stub
	}
	
	public Equation_In_Complete(String arg1) {
		super("Expression error:"+arg1);
		// TODO Auto-generated constructor stub
	}

	
}
