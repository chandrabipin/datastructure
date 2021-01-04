package javapractice;

public class OO90DedlockExampleThread1 extends Thread{

	public void run() {
		aMethod1();
	}
	private void aMethod1() {
		synchronized (Integer.class) {
			System.out.println("OO90DedlockExampleThread1.deadlockExample()....1");
	           try { Thread.sleep(100);} catch (Exception e) {}  
			synchronized (String.class) {
				System.out.println("OO90DedlockExampleThread1.deadlockExample()....2");				
			}
		}
	}
}
