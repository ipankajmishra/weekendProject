package com.sapient.ui;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import p1.exceptions.Equation_In_Complete;
import p1.exceptions.Invalid_operator;
import p1.exceptions.Invalid_value;
import p1.exceptions.ScientificOp;
import p1.exceptions.TrignometricOp;
import p1.runtimepoly.AirtmeticFactory;


public class Expression_Evaluator extends Evaluator {

	private String exprsion;
	private String exprsionArr[];
	private Double result=0.0;
	private String operators[]= {"+","-","*","/","%"};
	private String operatorMatch ="[+-x/%]";
	
	
	public String getExprsion() {
		return exprsion;
	}
	
	
	public void setExprsion(String exprsion) {
		this.exprsion = exprsion.toLowerCase();
	}
	

	public Expression_Evaluator(String exprsion) {
		super();
		this.exprsion = exprsion.toLowerCase();
	}
	
	public Expression_Evaluator() {
		super();
		exprsion = "";
	}
	
	
	public void evaluate() throws Exception
	{
		exprsionArr=exprsion.trim().split(" ");
		
		int operation =0;
		
		// throw a error if equation is not completed
		
		if ((operatorMatch).contains(exprsionArr[exprsionArr.length-1]))
			throw new Equation_In_Complete();
		
		
			for(String element : exprsionArr) {
			
			if(element.contentEquals("+")) {operation = 0; continue;}
			else if(element.contentEquals("-")) {operation = 1; continue;}
			else if(element.contentEquals("*")) {operation = 2; continue;}
			else if(element.contentEquals("/")) {operation = 3; continue;}
			else if(element.contentEquals("%")) {operation = 4; continue;}	
		result = AirtmeticFactory.getFactory(operation).cal(result, checkDigit(element));
			
		}
		
		
	}
	
	///////////////////////////////////////////
	
	
	
	private double checkDigit(String element) throws Exception{
		// TODO Auto-generated method stub
		try {
			return Double.valueOf(element.trim());
			
			}catch (Exception e) {
			
				String temps1[];
				double result1 =0.0;
			
				try {
					System.out.println(element);
					temps1 = element.trim().split("\\(");
					System.out.println(temps1[1]);
					result1 = Double.valueOf(temps1[1].trim().split("\\)")[0]);
				} catch (Exception e2) {
				throw new Invalid_value();
				}	
           	
            	System.out.println("okS" +temps1[0]);
            	if(checkScientific(temps1[0])) {
            		System.out.println(temps1[0]);
            		return scientificevl(temps1[0],result1);
            		
            	} else if(checkTrignometric(temps1[0])) {
            		return trignometricevl(temps1[0],result1);
            	}
            	else {
            		throw new Invalid_operator();
            	}
	
	}
		
	}

	//////////////////////////////////////
	
	private double trignometricevl(String temps1, double result1) throws Exception {
		double result=0.0;
		try {
			
			switch(TrignometricOp.valueOf(temps1)) {
			case sin : return Math.sin((result1*(3.14/180)));
			//break;
			case tan : return Math.tan((result1*(3.14/180)));
			case cos : return Math.cos((result1*(3.14/180)));
			case sec : return (Math.tan((result1*(3.14/180)))/ (Math.cos((result1*(3.14/180)))));
			//break;
			default : throw new Invalid_operator();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Invalid_operator();
		}
	}
	
	/////////////////////
	

	private boolean checkTrignometric(String temps1) {
try {
		switch(TrignometricOp.valueOf(temps1)) {
		case sin : return true;
		//break;
		case tan : return true;
		case cos : return true;
		//break;
		case sec : return true;
		//break;
		default : return false;
		}
}
catch (Exception e) {
	// TODO: handle exception
	return false;
}
	}

	
	////////////////////////////////
	
	private double scientificevl(String temps1, double result1) throws Exception {
		// TODO Auto-generated method stub
		double result=0.0;
		try {
			
			switch(ScientificOp.valueOf(temps1)) {
			case abs : return Math.abs(result1);
			//break;
			case sqrt : return Math.sqrt(result1);
			//break;
			default : throw new Invalid_operator();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Invalid_operator();
		}
		
	}
	
	//////////////////////

	private boolean checkScientific(String temps1) {
		// TODO Auto-generated method stub
		try {
		switch(ScientificOp.valueOf(temps1)) {
		case abs : return true;
		//break;
		case sqrt : return true;
		//break;
		default : return false;
		}
		}catch (Exception e) {
			return false;
		}
	}

	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "=" + result;
	}
	
	
	
	
	
	
	
	
	
}
