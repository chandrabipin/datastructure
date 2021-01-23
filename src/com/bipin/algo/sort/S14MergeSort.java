package com.bipin.algo.sort;

import java.util.*;

public class S14MergeSort{
	public static void main(String[] args){
		int[] intArr = {11,4,5,12,7,3,8,1,9,2,6};
		S14MergeSort s = new S14MergeSort();
		s.mergeSort(intArr, 0, intArr.length-1);
		System.out.println(Arrays.toString(intArr));
	}
	
	/**
	* Merge sort is divide and conquer Algorithm.
	* We divide given input array in two halves RECURSIVELY and continue dividing unless we ca not divide futher. 
	* Then we start merging them together and arranging in sorted order.
	* Final merge will give us final result.
	*
	*/
	private void mergeSort(int[] intArr, int startIndex, int endIndex){
		//Base condition to come out of the recursion
		//System.out.println("StartIndex: "+startIndex);
		//System.out.println("EndIndex: "+endIndex);
		if (endIndex > startIndex) { // Can not be broken further. If startIndex == endIndex -> its index is 0. i.e. can not be broken further.
			int middleIndex = (startIndex+endIndex)/2;// Remember this
			//1. Divide into two halves
			mergeSort(intArr,startIndex,middleIndex);
			mergeSort(intArr,middleIndex+1,endIndex);
			
			// 2. Merge the two halves together
			// 3. Create two local arrays LeftArray and RightArray 
			//	  Copy intArr[startIndex...middleIndex] into LeftArray
			//	  Copy intArr[middleIndex+1...endIndex] into RightArray
			int[] leftArray = new int[middleIndex-startIndex+1];
			int[] rightArray = new int[endIndex-(middleIndex+1)+1];
			for (int i=0;i<=middleIndex-startIndex;i++){
				leftArray[i] = intArr[startIndex+i];
			}
			for (int i=0;i<=endIndex-(middleIndex+1);i++){
				rightArray[i] = intArr[middleIndex+1+i];
			}
			
			int[] newMergedArr = merge(leftArray, rightArray);
			
			int count = startIndex;

			for(int k=0; k<=newMergedArr.length-1; k++){
				intArr[count]=newMergedArr[k];
				count++;
			}
			
		}
	}
	
		// Sort and Merge leftArray & rightArray into intArr.
	private int[] merge(int[] leftArray, int[] rightArray){
		System.out.println("leftArray:"+Arrays.toString(leftArray));
		System.out.println("rightArray:"+Arrays.toString(rightArray));
		int[] newIntArr = new int[leftArray.length+rightArray.length];
		int l=0;
		int r=0;
		int k=l;// Initial index of merged subarry array 
		while (l<leftArray.length && r<rightArray.length){
			System.out.println("l:"+l + " r:"+r+" :k"+k); 
			if(leftArray[l]<rightArray[r]){
				newIntArr[k]=leftArray[l];
				l++;
			}else{
				newIntArr[k]=rightArray[r];
				r++;
			}
			k++;
		}
		
        /* Copy remaining elements of L[] if any */
		while(l<leftArray.length){
			newIntArr[k]=leftArray[l];
			l++;
			k++;
		}
        /* Copy remaining elements of R[] if any */
		while(r<rightArray.length){
			newIntArr[k]=rightArray[r];
			r++;
			k++;
		}

		
		return newIntArr;
		
		
	}
}
