package javapractice;

public class OO91AvoidDedlockExampleDriverClass {
	public static void main(String[] args) {
		OO91AvoidDedlockExampleThread1 o1 = new OO91AvoidDedlockExampleThread1();
		OO91AvoidDedlockExampleThread2 o2 = new OO91AvoidDedlockExampleThread2();
		o1.start();
		o2.start();
	}
}
