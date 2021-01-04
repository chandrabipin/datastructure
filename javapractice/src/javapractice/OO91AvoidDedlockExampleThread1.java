package javapractice;

public class OO91AvoidDedlockExampleThread1 extends Thread{

	public void run() {
		aMethod2();
	}
	private void aMethod2() {
		synchronized (Integer.class) {
			System.out.println("OO91AvoidDedlockExampleThread1.deadlockExample()....1");
			try { Thread.sleep(100);} catch (Exception e) {}  
			synchronized (String.class) {
				System.out.println("OO91AvoidDedlockExampleThread1.deadlockExample()....2");				
			}
		}
	}
}
