package javapractice;

public class OP002NoSynchronizationProblemExample {

	//Create two separate threads of same object and try to access one common method simultaneously.
	//use new Thread(Object) - to pass the same thread in both of them
	//The common method should not have 'synchronized' key word.
	//This common method should be called from run() method of both the threads.
	//Common method should print a number based on the argument passed in a for loop
	//Add some Thread.sleep(400) in this common method - so that it takes some time to come out of the method.

	private void aMethod(int n) {
		for(int i=0;i<5;i++) {
			System.out.println("OP002NoSynchronizationProblemExample.aMethod(): i: " + i*n);
			try {
				Thread.sleep(400);
			}catch(Exception e){}
		}
	}
	
	//driver method
	public static void main(String[] args) {
		
		OP002NoSynchronizationProblemExample o = new OP002NoSynchronizationProblemExample();
		Thread t1 = new Thread() {
			public void run() {
				o.aMethod(5);//important you can call o.aMethod();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				o.aMethod(100);
			}
		};
		
		t1.start();
		t2.start();
	}
}
