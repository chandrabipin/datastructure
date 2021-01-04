package javapractice;

public class OO5GenericDriverClass{

	public static void main(String[] args) {
		//Test Generic Class with 1 type i.e. <T>
		OO4GenericClassExample<String> obj1 = new OO4GenericClassExample<String>("I am first generic class with 1 type only");
		obj1.aMethod();
		
		OO4GenericClassExample<Double> obj2 = new OO4GenericClassExample<Double>(12.02);
		obj2.aMethod();
		//Test Generic Class with 2 type i.e. <T,U>
		OO4GenericClassExample2<String,Double> obj3 = new OO4GenericClassExample2<String,Double>("I am first generic class with 1 type only", 12.22);
		obj3.aMethod();
		
		//Test Generic Function
		OO4GenericFunctionExample g = new OO4GenericFunctionExample();
		g.aMethod("I am a String");
		g.aMethod(12.1111);
		g.aMethod(7);
		g.aMethod(new Object());
	}

}
