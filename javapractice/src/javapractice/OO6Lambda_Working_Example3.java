package javapractice;

import java.util.ArrayList;

public class OO6Lambda_Working_Example3 {

	interface FuncInterface3{
		//only one abstract method
		void message(String str);
	}
	//driver method
	public static void main(String[] args) {
		FuncInterface3 f3 = (message) -> System.out.println("Hi, " + message);
		f3.message("Bipin.");
	}
}
