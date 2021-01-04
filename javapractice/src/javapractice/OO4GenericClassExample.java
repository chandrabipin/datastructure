package javapractice;

public class OO4GenericClassExample <T>{

	T tObj = null;
	
	OO4GenericClassExample(T t){
		this.tObj=t;
	}
	
	public T aMethod() {
		System.out.println("OO4GenericClassExample.aMethod(): " + this.tObj.getClass().getName() +"="+this.tObj);
		return this.tObj;
	}

}
