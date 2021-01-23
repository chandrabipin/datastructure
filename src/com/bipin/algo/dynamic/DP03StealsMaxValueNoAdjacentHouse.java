package com.bipin.algo.dynamic;

import java.util.*;

public class DP03StealsMaxValueNoAdjacentHouse{
	public static void main(String[] args){
		//input 
		//int[] houseValue = {6,7,1,30,8,2,4};
		int[] houseValue = {20,5,1,13,6,11,40};
		int[] memoization = new int[houseValue.length];
		DP03StealsMaxValueNoAdjacentHouse dp = new DP03StealsMaxValueNoAdjacentHouse();
		int result = dp.calculateMaxValueNoAdjacentHouse(memoization, houseValue, 0);
		System.out.println(result);
	}
	
	// Only two options
	// Steals from current house or
	// Skips current house
	private int calculateMaxValueNoAdjacentHouse(int[] memoization, int[] houseValue, int currentIndex){
		if(currentIndex>houseValue.length-1){
			return 0;
		}
		
		if(memoization[currentIndex]==0){
			//1.
			int op1 = houseValue[currentIndex] + calculateMaxValueNoAdjacentHouse(memoization, houseValue, currentIndex+2);//skip next house hence +2
			//2.
			int op2 = calculateMaxValueNoAdjacentHouse(memoization, houseValue, currentIndex+1);//skip current house hence +1
			memoization[currentIndex] = Math.max(op1,op2);
		}
		
		return memoization[currentIndex];
		
	}
	
	
}