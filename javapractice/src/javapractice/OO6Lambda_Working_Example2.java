package javapractice;

import java.util.ArrayList;

public class OO6Lambda_Working_Example2 {

	interface FuncInterface1 {
		//only one abstract method
		public int opertaion(int a, int b);
		//it can have other non-abstract or default methods.
		default void printMessageFunInt1() {
			System.out.println("FuncInterface1.Test.printMessageFunInt1()");
		}
	}
	
	interface FuncInterface2{
		//only one abstract method
		public void message();
		//it can have other non-abstract or default methods.
		default void printMessageFunInt2() {
			System.out.println("FuncInterface1.Test.printMessageFunInt2()");
		}
	}

	interface FuncInterface3{
		//only one abstract method
		void message(String str);
	}
	//driver method
	public static void main(String[] args) {
		FuncInterface1 add = (int a, int b) -> {return a+b;};
		FuncInterface1 multiply = (int a, int b) -> {return a*b;};
		
		OO6Lambda_Working_Example2 o = new OO6Lambda_Working_Example2();
		FuncInterface2 f2_1 = () -> {System.out.println(o.doOpertaion(10, 20, add));};
		FuncInterface2 f2_2 = () -> {System.out.println(o.doOpertaion(10, 20, multiply));};
		f2_1.message();
		f2_2.message();
		FuncInterface3 f3 = (message) -> System.out.println("Hi, " + message);
		f3.message("Bipin.");


	}
	
	private int doOpertaion(int a, int b, FuncInterface1 op) {
		return op.opertaion(a, b);
	}

}
