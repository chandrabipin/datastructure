package javapractice;

public class OO90DedlockExampleThread2 extends Thread{

	public void run() {
		aMethod2();
	}
	private void aMethod2() {
		synchronized (String.class) {
			System.out.println("OO90DedlockExampleThread2.deadlockExample()....1");
			try { Thread.sleep(100);} catch (Exception e) {}  
			synchronized (Integer.class) {
				System.out.println("OO90DedlockExampleThread2.deadlockExample()....2");				
			}
		}
	}
}
