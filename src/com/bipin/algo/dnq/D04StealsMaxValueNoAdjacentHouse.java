package com.bipin.algo.dnq;

import java.util.*;

public class D04StealsMaxValueNoAdjacentHouse{
	public static void main(String[] args){
		//Input
		// House value: {6,7,1,30,8,2,4}
		//int[] houseValue = {6,7,1,30,8,2,4};
		int[] houseValue = {20,5,1,13,6,11,40};
		D04StealsMaxValueNoAdjacentHouse d = new D04StealsMaxValueNoAdjacentHouse();
		int result = d.getMaxValueNoAdjacentHouse(houseValue,0);
		System.out.println(result);
	}
	
	private int getMaxValueNoAdjacentHouse(int[] houseValue,int currentIndex){
		// Either steals from currentIndex     -> houseValue[currentIndex] + f(remaining 5 elements <skipped next value 7>)
		// OR skips currentIndex -> 0 + f(remaining 6 elements)
		// f(7)=MAX[6+f(5),f(6)] -> f~getMaxValueNoAdjacentHouse

		//base condition
		if(currentIndex>=houseValue.length)
			return 0;
		
		return Math.max(houseValue[currentIndex]+getMaxValueNoAdjacentHouse(houseValue, currentIndex+2), 
					getMaxValueNoAdjacentHouse(houseValue, currentIndex+1));
		
		
	}
}