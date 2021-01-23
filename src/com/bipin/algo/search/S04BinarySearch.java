package com.bipin.algo.search;

public class S04BinarySearch{

	// Find a number in sorted array using binary search
	public static void main(String[] arr){
		int numberToSearch = 18;
		int[] intArr = {1,2,3,4,5,6,7,8,9,10};
		S04BinarySearch s = new S04BinarySearch();
		boolean result = s.isNumberExistInSortedArray(intArr, 0, intArr.length-1,numberToSearch);
		System.out.println(result);
	}
	
	private boolean isNumberExistInSortedArray(int[] intArr, int startIndex, int endIndex, int numberToSearch)
	{
        if (endIndex >= startIndex) {//This condition is important. If missed, it will create stackoverflow exception.
			int mid = startIndex + (endIndex-startIndex)/2;// Remember this. This is what we forget. How to calculate mid.
			if (intArr[mid] == numberToSearch)
				return true;
			else if (intArr[mid] > numberToSearch){
				return isNumberExistInSortedArray(intArr, startIndex, mid-1, numberToSearch);
			}
			return isNumberExistInSortedArray(intArr, mid+1, endIndex, numberToSearch);
		}
		return false;
	}

}

