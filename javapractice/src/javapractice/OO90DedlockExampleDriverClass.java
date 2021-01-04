package javapractice;

public class OO90DedlockExampleDriverClass {
	public static void main(String[] args) {
		OO90DedlockExampleThread1 o1 = new OO90DedlockExampleThread1();
		OO90DedlockExampleThread2 o2 = new OO90DedlockExampleThread2();
		o1.start();
		o2.start();
	}
}
