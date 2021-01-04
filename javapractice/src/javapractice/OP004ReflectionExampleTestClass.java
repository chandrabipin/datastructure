/**
 * 
 */
package javapractice;

/**
 * @author Bipin.Chandra
 *
 */
public class OP004ReflectionExampleTestClass {

	//public constructor
	public OP004ReflectionExampleTestClass() {
		System.out.println("OP004ReflectionExampleTestClass.OP004ReflectionExampleTestClass() - I am in a constructor.");
	}

	public int publicField1 = 100;
	public int publicField2 = 200;
	
	private int privateField = 300;
	
	private void privateMethod(int a) {
		System.out.println("OP004ReflectionExampleTestClass.privateMethod(): " + a);
	}
	
	public void publicMethod1(int a) {
		System.out.println("OP004ReflectionExampleTestClass.publicMethod1(): " + a);
	}
	
	public void publicMethod2(int a) {
		System.out.println("OP004ReflectionExampleTestClass.publicMethod2(): " + a);
	}

	/**
	 * @return the privateField
	 */
	public int getPrivateField() {
		return privateField;
	}

	/**
	 * @param privateField the privateField to set
	 */
	public void setPrivateField(int privateField) {
		this.privateField = privateField;
	}
	
}
