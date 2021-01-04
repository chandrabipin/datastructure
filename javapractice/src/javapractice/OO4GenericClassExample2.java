package javapractice;

public class OO4GenericClassExample2 <T,U>{

	T tObj = null;
	U uObj = null;
	public OO4GenericClassExample2(T t, U u) {
		this.tObj=t;
		this.uObj=u;
	}
	public T aMethod() {
		System.out.println("OO4GenericClassExample.aMethod(): " + this.tObj.getClass().getName()+"="+this.tObj);
		System.out.println("OO4GenericClassExample.aMethod(): " + this.uObj.getClass().getName()+"="+this.uObj);
		return this.tObj;
	}

}
