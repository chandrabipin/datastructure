package com.bchandra.datastructure;

public class OO1IntegerArray {

	// Create a blank array
	int[] intArr = null;
	
	public static void main(String[] args) {
		OO1IntegerArray array = new OO1IntegerArray();
		array.createAnIntegerArray(10);
		array.traverseArray();
		System.out.println("-------------------------");
		array.initializeArrayToBlankValue();
		array.traverseArray();
		System.out.println("-------------------------");
		array.insertIntoArray(10);
		array.insertIntoArray(20);
		array.insertIntoArray(30);
		array.insertIntoArray(40);
		array.insertIntoArray(50);
		array.insertIntoArray(60);
		array.traverseArray();
		System.out.println("-------------------------");
		array.deleteAnElementFromArray(0);
		array.traverseArray();
		System.out.println("-------------------------");
		array.deleteArray();
		
		System.out.println("OO1IntegerArray.main(): " + array.intArr);
	}
	
	/**
	 * Create an integer array with the given size 
	 */
	public int[] createAnIntegerArray(int arrSize) {
		if(intArr == null) {
			intArr = new int[arrSize];//default value of each element is 0. Use initializeArrayToBlankValue() to mark it blank
		}
		return intArr;
	}
	
	/**
	 * Insert a value into an int array
	 */
	public boolean initializeArrayToBlankValue() {
		boolean returnValue = true;
		if(intArr==null) {// if intArr is null
			returnValue = false;
		} else {
			int i=0;
			for (int elementValue : intArr) {
				// check if element has a value - if not insert a value
				if(elementValue == 0) {
					intArr[i]=Integer.MIN_VALUE;//mark it blank
					returnValue=true;
				}
				i++;
			}
		}
		return returnValue;
	}

	/**
	 * Insert a value into an int array
	 */
	public boolean insertIntoArray(int aValue) {
		boolean returnValue = true;
		if(intArr==null) {// if intArr is null
			returnValue = false;
		} else {
			int i=0;
			for (int elementValue : intArr) {
				// check if element has a value - if not insert a value
				if(elementValue == Integer.MIN_VALUE) {
					intArr[i]=aValue;
					returnValue=true;
					break;
				}
				i++;
			}
		}
		return returnValue;
	}
	
	/**
	 * traverse array
	 */
	
	public void traverseArray() {
		if(intArr==null) {
			System.out.println("Array.traverseArray():" + "Array is null");
			return;
		}
		for (int elementValue : intArr) {
			System.out.println("Array elements:"+elementValue);
		}
	}
	
	/**
	 * delete a cell value
	 */
	public void deleteAnElementFromArray(int index) {
		if(intArr==null) {
			System.out.println("Array.deleteAnElementFromArray():" + "Array is null");
			return;
		}
		intArr[index]=Integer.MIN_VALUE;//mark it deleted
	}
	
	/**
	 * delete an entire array
	 */
	public void deleteArray() {
		intArr = null;
	}
}
