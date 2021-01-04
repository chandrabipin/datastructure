package javapractice;

import java.util.ArrayList;

public class OO6Lambda_forEach_Example { 

	
	//driver method
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("bipin");
		a.add("chandra");
		a.add("srivastava");
		
		a.forEach(n -> {System.out.println("OO6Lambda_foreach_Example.main()"+n);});


	}

}
