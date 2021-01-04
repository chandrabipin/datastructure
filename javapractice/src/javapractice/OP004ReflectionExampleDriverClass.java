/**
 * 
 */
package javapractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Bipin.Chandra
 *
 */
public class OP004ReflectionExampleDriverClass {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		OP004ReflectionExampleTestClass testObj = new OP004ReflectionExampleTestClass();
		
		//1. Get the class object
		Class cls = testObj.getClass();
		
		//2 Find all the public methods
		Method[] methods = cls.getMethods();
		for(Method method:methods) {
			System.out.println(method);
		}

		System.out.println("\n");
		
		//3 Find all public fields
		Field[] fields = cls.getFields();
		for(Field field:fields) {
			System.out.println(field);
		}
		
		System.out.println("\n");

		//4 Find all public constructor/s
		Constructor[] constructors = cls.getConstructors();
		for(Constructor constructor:constructors) {
			System.out.println(constructor);
		}
		
		System.out.println("\n");

		//5 Get and assign a private field
		Field pv = cls.getDeclaredField("privateField");
		pv.setAccessible(true);// It will be accessible even if it is private
		try {
			pv.set(testObj, 500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OP004ReflectionExampleDriverClass.main(): " + testObj.getPrivateField());
		
		System.out.println("\n");

		//6 invoke a public method
		Method method = cls.getDeclaredMethod("publicMethod1", int.class);
		method.invoke(testObj, 600);
		
		System.out.println("\n");
		
		//7 invoke a private method
		Method method2 = cls.getDeclaredMethod("privateMethod", int.class);
		method2.setAccessible(true);
		method2.invoke(testObj, 700);
	}
}
