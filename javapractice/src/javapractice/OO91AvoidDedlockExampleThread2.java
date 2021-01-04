package javapractice;

public class OO91AvoidDedlockExampleThread2 extends Thread{

	public void run() {
		aMethod1();
	}
	private void aMethod1() {
		synchronized (Integer.class) {
			System.out.println("OO91AvoidDedlockExampleThread2.deadlockExample()....1");
	           try { Thread.sleep(100);} catch (Exception e) {}  
			synchronized (String.class) {
				System.out.println("OO91AvoidDedlockExampleThread2.deadlockExample()....2");				
			}
		}
	}
}
