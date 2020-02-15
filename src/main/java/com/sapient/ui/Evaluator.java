package com.sapient.ui;

import java.util.ArrayList;
import java.util.List;

public abstract class Evaluator {
	public static List<String> ob= new  ArrayList<>();;
	public Evaluator() {
		//ob = new  ArrayList<>();
	}
	
	public abstract void evaluate() throws Exception;
	
	public void addHistory(String x) {
		ob.add(x);
	}
	
	public void displayHistory() {
		
		ob.forEach(System.out::println);
	}
}
