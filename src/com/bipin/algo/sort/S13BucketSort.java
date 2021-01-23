package com.bipin.algo.sort;

import java.util.*;

public class S13BucketSort {
	public static void main (String args[]){
		int[] intArr = {11,4,5,12,7,3,8,1,9,2,6};
		S13BucketSort s = new S13BucketSort();
		s.bucketSort(intArr);
	}
	
	
	/**
	* Create as many bucket we need i.e. B1[], B2[], B3[]
	* Formula to choose number of buckets = Math.ceil(Math.sqrt(arr.length))
	* Create an array of ArrayList with size as 'number of buckets'.
	* Pick one value from the intArr and put in one of the array using this formula:
	* Select bucket to put the value = Ceil(Value * number of total buckets)/ Max value in array.
	* i.e = Math.ceil ((value *  numberOfBuckets) / maxValue);
	*/
	
	private void bucketSort(int[] intArr){
		//1. Find min and max from the array
		//2. Find n Number of buckets needed
		//3. Create Array of 'ArrayList of size n' * initialize them.
		//4. Put value is respective buckets
		//5. Sort each ArrayList inside the array. Using COllections.sort(arrayList);
		//6. Concatenate Array
		//7. Print Array
		
		//1.
		double max=-1.0;// This has to be double and not int.
		for(int i=0;i<intArr.length;i++){
			if(intArr[i]>max){
				max=intArr[i];
			}
		}

		//2.
		int n = (int)Math.ceil((int)Math.sqrt(intArr.length));

		//3.
		ArrayList<Integer>[] anArrOfArrayListObj = new ArrayList[n];/// very important step
		for(int i=0;i<n;i++){
			anArrOfArrayListObj[i] = new ArrayList<Integer>();//initialize each ArrayList object
		}

		//4.
		for(int i=0; i<intArr.length; i++){
			int bucketIndex = (int)Math.ceil(((intArr[i]*n))/max);//(int) typecast is necessary . If I put 'max' as int then Ceiling[3*3/12] becomes 0.0 and then it throws ArrayIndexBoundOfException. Hence it has to be double. Ceiling[3*3/12.0] gives 1.0.
			//System.out.println("bucketIndex: " + bucketIndex);
			anArrOfArrayListObj[bucketIndex-1].add(intArr[i]);//Since ceiling will make it to start with 1. And hence we make it -1.
		}
		
		//5.
		for(int i=0;i<n;i++){
			Collections.sort(anArrOfArrayListObj[i]);
		}
		
		//6.
		int[] sortedArr = new int[intArr.length];
		int k=0;
		for(ArrayList<Integer> arrListObj:anArrOfArrayListObj){
			for(int value : arrListObj){
				sortedArr[k]=value;
				k++;
			}
		}
		
		//7.
		System.out.println(java.util.Arrays.toString(sortedArr));
	}
}