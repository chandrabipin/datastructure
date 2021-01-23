package com.bipin.algo.sort;

import java.util.Arrays;

public class S11SelectionSort{

	public static void main(String[] args){
		int[] intArr = {11,4,5,12,7,3,8,1,9,2,6};
		System.out.println(Arrays.toString(intArr));
		System.out.println("\n" 	);
		S11SelectionSort s = new S11SelectionSort();
		s.selectionSort(intArr);
	}

	/**
	* find min or max in each iteration from the unsorted array. [In our example we used min]
	* put it at right place in the sorted array.
	* 'Same' array can be divided into [sorted|unsorted] array.
	* In each iteration increase the sorted part and reduce the unsorted part.
	*/
	private void selectionSort(int[] intArr){
		for(int j=0;j<=intArr.length-1;j++){ // Note the condition - 'j<=intArr.length-1'
			int tempMinVal=intArr[j];//Assume first element as min and compare with rest of the elements accordingly.
			int minIndex=j;//Remember: should be inside the for loop. For each iteration - assume first element to be min and compare with rest of the elements accordingly.
			for(int i=j+1;i<=intArr.length-1;i++){
				if(intArr[i]<tempMinVal){
					tempMinVal=intArr[i];
					minIndex=i;
				}
			}
			if(j!=minIndex){//swap
				int temp;
				temp = intArr[j];
				intArr[j]=intArr[minIndex];
				intArr[minIndex]=temp;
			}
		System.out.println(Arrays.toString(intArr));
		}
	}
}
