package com.bipin.algo.greedy;

import java.util.*;

public class G03FindMaxValueForGivenWeight{
	public static void main(String[] args){
		// input gold wt and value
		// knapsack max capacity
		ArrayList<G03GoldType> arrList = new ArrayList<G03GoldType>();
		arrList.add(new G03GoldType("Gold-1", 20, 100));
		arrList.add(new G03GoldType("Gold-2", 30, 120));
		arrList.add(new G03GoldType("Gold-3", 10, 60));
		
		int maxCap = 50;//50kg
		
		G03FindMaxValueForGivenWeight g = new G03FindMaxValueForGivenWeight();
		g.findMaxValueForGivenWeight(arrList, maxCap);
	}
	
	private void findMaxValueForGivenWeight(ArrayList<G03GoldType> arrList, int maxCap){
		//Sort density in descending order
		//Pick from max density first and last one should be broken to fix the remianing wt.
		int totalValue=0;
		int totalWt=0;
		Collections.sort(arrList, new G03ComparatorDensityDesc()); //Sort in descending order with Density
		for(G03GoldType goldType:arrList){
			System.out.println(goldType.getGoldType());
			int remainingCapacity = maxCap-totalWt;
			if(remainingCapacity>0){
				totalValue = totalValue+goldType.getValue();
				totalWt = totalWt+goldType.getWeight();
				//break the gold for remaining capacity
				if(totalWt>maxCap){
					totalValue = totalValue-goldType.getValue();
					totalWt = totalWt-goldType.getWeight();
					int remainingWt = maxCap-totalWt;
					double valuePicked = remainingWt*goldType.getDensity();
					totalValue=(int)(totalValue+valuePicked);
				}
			}
		}
		System.out.println(totalValue);
		
	}
}