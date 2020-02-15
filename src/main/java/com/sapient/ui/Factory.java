package com.sapient.ui;

public class Factory {
	
	public static Evaluator getEvaluatro(int ch,String x) {
		
		if(ch==0) return new Date_Evaluator(x);
		else 
			return new Expression_Evaluator(x);
	}

}
