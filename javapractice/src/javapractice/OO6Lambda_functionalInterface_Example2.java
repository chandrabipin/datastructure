package javapractice;

import java.util.ArrayList;

public class OO6Lambda_functionalInterface_Example2 {

	interface Test{
		//only one abstract method
		public int oneMethod();
		//it can have other non-abstract or default methods.
		default void twoMethod() {
			System.out.println("OO6Lambda_functionalInterface_Example2.Test.enclosing_method()");
		}
	}
	
	//driver method
	public static void main(String[] args) {
		Test t = () -> {System.out.println("Lambda: No argument");return 1;};
		// Very smart
		// Don't think that how above is assigned to TestInterface when this method returns int
		// Things are happening inside - and this is how it happens.
		// You have to call that method explicitly to invoke it.
		t.oneMethod();
		t.twoMethod();


	}

}
