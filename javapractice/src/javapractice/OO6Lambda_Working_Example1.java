package javapractice;

import java.util.ArrayList;

public class OO6Lambda_Working_Example1 {

	interface FuncInterface1 {
		//only one abstract method
		public int opertaion(int a, int b);
	}
	
	//driver method
	public static void main(String[] args) {
		FuncInterface1 add = (int a, int b) -> {return a+b;}; // like one implementation of above method is doing addition
		FuncInterface1 multiply = (int a, int b) -> {return a*b;}; // and other implementation is doing multiplication
		
		OO6Lambda_Working_Example1 o = new OO6Lambda_Working_Example1();	
		System.out.println(o.doOpertaion(10, 20, add));
		System.out.println(o.doOpertaion(10, 20, multiply));
	}
	
	private int doOpertaion(int a, int b, FuncInterface1 op) {
		return op.opertaion(a, b);
	}

}
