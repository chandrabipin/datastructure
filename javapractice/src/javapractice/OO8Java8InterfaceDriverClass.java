package javapractice;

public class OO8Java8InterfaceDriverClass {

	public static void main(String[] args) {
		//Invoke Interface's abstract method after its implementation
		OO8Java8Interface i = new OO8Java8InterfaceImpl();
		i.abstractShowMessage("My name is Bipin!");
		
		//Invoke Interface's default method
		System.out.println("OO8Java8InterfaceDriverClass.defaultAdd()-: " + i.defaultAdd(10, 20));
		
		//Invoke Interface's static method
		System.out.println("OO8Java8InterfaceDriverClass.staticMultiply()-: " + OO8Java8Interface.staticMultiply(10, 20));


	}

}
