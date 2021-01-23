package com.bipin.algo.dnq;

import java.util.*;

public class D06FindMaxValueForGivenWeight{
	public static void main(String[] args){
		//input
		int knapsackCapacity = 7;
		ArrayList<D06ProfitWt> arrList = new ArrayList<>();
		arrList.add(new D06ProfitWt("Mango", 31, 3));
		arrList.add(new D06ProfitWt("Aple", 26, 1));
		arrList.add(new D06ProfitWt("Banana", 72, 5));
		arrList.add(new D06ProfitWt("Orange", 17, 2));
		
		D06FindMaxValueForGivenWeight d = new D06FindMaxValueForGivenWeight();
		int result = d.findMaxValueForGivenWeight(arrList, knapsackCapacity, 0);
		System.out.println(result);
	}
	
	private int findMaxValueForGivenWeight(ArrayList<D06ProfitWt> arrList, int knapsackCapacity, int currentIndex){
		if(knapsackCapacity<=0 || currentIndex > arrList.size()-1){
			return 0;
		}
		int currentWeight = arrList.get(currentIndex).getWt();
		int currentProfit = arrList.get(currentIndex).getProfit();
		
		// at each step 
		// either we choose that weight and profit, if we choose - check if current wt is less than or equal to leftover capacity.
		// or we do not choose it
		int p1 = 0;
		if(currentWeight<=knapsackCapacity)// Very important. I had missed this and was getting incorrect result. Remaining capacity has to be equal or greater than the currentwt. You can not divide the current wt here.
			p1 = currentProfit + findMaxValueForGivenWeight(arrList, knapsackCapacity-currentWeight, currentIndex+1);
		int p2 = findMaxValueForGivenWeight(arrList, knapsackCapacity, currentIndex+1);
		
		return Math.max(p1, p2);// We dont
	}
}

