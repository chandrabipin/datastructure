package com.bipin.algo.sort;

import java.util.Arrays;

public class S10BubbleSort{

	//Property:
	//BubbleSort or Sinking Sort
	//Compare each number in the array from previous number.
	//Swap if the order is wrong
	//Last element will be at right position
	//Repeat till last but one in each round
	public static void main(String[] args){
		int[] arr = {2,4,6,9,3,1};
		S10BubbleSort s = new S10BubbleSort();
		s.bubbleSort(arr);
	}
	
	private void bubbleSort(int[] arr){
		int tempNum = -1;
		int length=arr.length;
		for(int j=0;j<=arr.length-1;j++){//iterate - reduce one last in each iteration
			for(int i=0;i<=length-2;i++){//iterate till one less than last num.
				if(arr[i]>arr[i+1]){//if order is wrong -> do swap
					tempNum = arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=tempNum;
				}
				
//		System.out.println(Arrays.toString(arr));
			}
			length=length-1;
		}
		
		System.out.println(Arrays.toString(arr));//Note:- How to print the int array. Use import for java.util.Arrays;
	}

}