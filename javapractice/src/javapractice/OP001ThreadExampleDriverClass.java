package javapractice;

public class OP001ThreadExampleDriverClass {

	public static void main(String[] args) {
		OP001ThreadExampleUsingThreadClass t = new OP001ThreadExampleUsingThreadClass();
		t.start();
		
		OP001ThreadExampleUsingRunnableInterface r = new OP001ThreadExampleUsingRunnableInterface();
		Thread t2 = new Thread(r);// This step is important
		t2.start();
	}
}
