package com.sapient.ui;

import java.util.Scanner;
import java.util.StringTokenizer;

import p1.exceptions.Invalid_date_Exception;



public class CalculatorDemoV2 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		
		
		while(true) {
			System.out.println();
			System.out.println("-----------Choose the Calculator functionality ------");
			System.out.println("1:Scientific Calculator");
			System.out.println("2:Date Calculator");
			
			int input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1:
				String expression = sc.nextLine();
				try {
					System.out.println(scientificCalculation(expression));
				}catch(Exception e) {
					System.out.println("Error Message : "+e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter dates(yyyy/MM/dd hh:mm) to calculate\nFor Example - 2019/10/20 - 3 or 2019/10/20 + 3");
				
				String x = sc.nextLine();
				//System.out.println(dateCalculator(0,x));
				
				try {
					Evaluator ob = dateCalculator(0,x);
					System.out.println("Output : "+ob);
					System.out.println();
					System.out.println("History : ");
					ob.displayHistory();
					System.out.println();
				}catch(Exception e) {
					System.out.println("Error Message : "+e.getMessage());
				}
				
				
				break;
			default: 
	            System.out.println("Invalid input"); 
	            break; 
	        } 
		}
			
				
		
		
		

		
		


	}

	public static Evaluator dateCalculator(int a,String x1) throws Exception {
		Evaluator ob = Factory.getEvaluatro(0,x1);
		try {
			//Date_Evaluator ob = new Date_Evaluator(x);

			ob.evaluate();


			return(ob);
		}
		catch (Invalid_date_Exception e) {
			// TODO: handle exception
			//System.out.println(e);
			throw e;
		}
	}

	public static Expression_Evaluator scientificCalculation(String expression) throws Exception {
		try {
			return(expressionEval(expression));
		}catch(Exception e) {
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			throw e;
		}
		
	}

	private static Expression_Evaluator expressionEval(String expression) throws Exception {
		try {

			Expression_Evaluator ob = new Expression_Evaluator(expression);
			ob.evaluate();
			return ob;

		}
		catch (Exception e) {
			throw e;
		}// TODO Auto-generated method stub

	}

}
