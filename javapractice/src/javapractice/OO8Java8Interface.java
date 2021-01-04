package javapractice;

public interface OO8Java8Interface {

	void abstractShowMessage(String message);// public abstract method by default
	
	default int defaultAdd(int a, int b) {// default method
		return a+b;
	}
	
	static int staticMultiply(int a, int b) {// static method
		return a*b;
	}
}
