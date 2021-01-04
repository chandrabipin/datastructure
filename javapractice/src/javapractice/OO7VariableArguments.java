package javapractice;

public class OO7VariableArguments {

	private void printMessage(String ...str) {
		System.out.println("OO7VariableArguments.printMessage(): Length: " + str.length);
		if(str.length==0) System.out.println("OO7VariableArguments.printMessage(): Empty");
		for(int i=0; i < str.length ; i++) {
			System.out.println("OO7VariableArguments.printMessage(): " + str[i]);
		}
	}
	
	//Driver method
	public static void main(String[] args) {
		OO7VariableArguments o = new OO7VariableArguments();
		o.printMessage();// arguments can be 0 or more
		o.printMessage("A");
		o.printMessage("A","B");
		o.printMessage("A","B","C");
	}

}
