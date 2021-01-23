package com.bipin.algo.sort;

import java.util.*;

public class S15QuickSort{
	public static void main(String[] args){
		int[] intArr = {11,4,5,12,7,3,8,1,9,2,6};
		S15QuickSort s = new S15QuickSort();
		s.quickSort(intArr, 0, intArr.length-1);
		System.out.println(Arrays.toString(intArr));
	}
	
	/**
	* Divide and COnquer algo
	* Find pivit at each step. Ensure all smaller number or on left of the pivot and greater numbrs on the right side of pivot.
	* Do recursion on left of the pivot and then on right on the pivot.
	* In quicksort - we take care of just 3 elements.
	* i, j, p
	* p is only the pivot which is the always the last element in the array or subarray.
	* j is the first element in the array
	* i is always initialize to j-1.
	* if j=0 then i=-1.
	* Every step compare arr[j] with arr[p].
	* if(arr[j]<=arr[p]) -> then increase i by 1 and swap arr[i] and arr[j].
	* Repeat the recursion.
	*/
	private void quickSort(int[] intArr, int startIndex, int endIndex){
		//int[] intArr = {11,4,5,12,7,3,8,1,9,2,6};
		//int[] intArr = {4,11,5,12,7,3,8,1,9,2,6};
		if (endIndex > startIndex){//base condition
			int i=startIndex-1;
			int j=startIndex;
			int pivotIndex = endIndex;//Initial location of pivot
			while(j<=pivotIndex){// If small - then swap arr[i+1] with arr[j]
				if(intArr[j]<=intArr[pivotIndex]){
					i++;
					swap(intArr, i,j);
				}
				if(j==pivotIndex){
					pivotIndex=i;
					break;
				}
				j++;
			}
			
			// j is the new position of p. Divide from start to j-1 and j+1 to end.
			quickSort(intArr, startIndex, pivotIndex-1);
			quickSort(intArr, pivotIndex+1, endIndex);
		}		
		
	}
	
	private void swap(int[] intArr, int i, int j){
		int temp = intArr[i];
		intArr[i]=intArr[j];
		intArr[j]=temp;
	}
}