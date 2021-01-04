package javapractice;

public class OP002StaticSynchronizedMethodExample {

	//Create two separate threads of same object and try to access one common method simultaneously.
	//use new Thread(Object) - to pass the same thread in both of them
	//This common method should be static
	//The common method should 'synchronized' key word in starting of the method.
	//This common method should be called from run() method of both the threads.
	//Common method should print a number based on the argument passed in a for loop.
	//Add some Thread.sleep(400) in this common method - so that it takes some time to come out of the method.

	synchronized static private void aMethod(int n) {
		for(int i=0;i<5;i++) {
			System.out.println("OP002ObjectSynchronizedBlockExample.aMethod(): i: " + i*n);
			try {
				Thread.sleep(400);
			}catch(Exception e){}
		}
	}
	
	//driver method
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				aMethod(5);//important you can call static aMethod();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				aMethod(100);
			}
		};
		
		t1.start();
		t2.start();
	}
}
