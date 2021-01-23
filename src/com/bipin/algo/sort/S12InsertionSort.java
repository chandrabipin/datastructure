package com.bipin.algo.sort;

import java.util.Arrays;

public class S12InsertionSort{
	
	public static void main(String[] args){
		int[] intArr = {11,4,5,12,7,3,8,1,9,2,6};
		S12InsertionSort s = new S12InsertionSort();
		s.insertionSort(intArr);
	}
	
	/**
	* Divide 'same' array into [sorted|unsorted] array.
	* Pick each element from unsorted array and put it at the correct place in sorted array.
	* Starting: sorted array will be blank and unsorted array will be whole of intArr.
	* 
	*/
	
	/**
	* Create two counters for same array i and j.
	* array ...i... for picking the value one by one (in temp variable) from the unsorted array
	* and array ...j... for sorted array
	* we will iterate the array ...j... in reverse order and compare the value with temp 
	* With each comparison - if the temp value is small than that of array ...j.... then re increase the position of array ...j... 
	* and conitinue
	* Once you get the final place. Then place the temp there.
	* Note:- while iterating arrays - the size of sorted array i.e. array ...j... will alway be equal to i+1.
	* Start: from 1. Assume intArr[0] as sorted.
	*/
	private void insertionSort(int[] intArr){
		for(int i = 1;i<=intArr.length-1; i++){//Note the condition - for unsorted array
			int temp = intArr[i];
			int j=i;
			while ( j>0 && intArr[j-1]>temp ) {	//Note the condition - for sorted array. Use while loop instead of for loop. Because you need counter j out of the loop.
					intArr[j]=intArr[j-1];
					j--;
			}
			intArr[j]=temp;//Finally putting the temp at ots right place.
		}
		System.out.println(Arrays.toString(intArr));
	}
}