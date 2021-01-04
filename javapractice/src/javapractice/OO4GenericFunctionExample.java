package javapractice;

public class OO4GenericFunctionExample{

	// A Generic method example. Similar to defining in class level. We are defining the unknown type at method level like below.
	public <T> void aMethod(T t) {
		System.out.println("OO4GenericClassExample.aMethod(): " + t.getClass().getName() + "=" + t);
	}

}
