package com.bipin.algo.greedy;

import java.util.*;

public class G02FindMinNoOfCoins{
	public static void main(String[] args){
		//input
		//i>  Create public static void main and start with the 'given input' as a first step.
		Integer[] coinsDenomination = {1,2,5,10,20,50,100,500,1000};// It is Integer and not int primitive type as Collections.reverseOrder() does not work with primitive data type.
		int inputValue = 2045;//Other inputs 70,121,2045
		
		//ii> Create class's object and invoke its algo's method and pass the input as arguments.
		G02FindMinNoOfCoins g = new G02FindMinNoOfCoins();
		g.findMinNoOfCoins(coinsDenomination, inputValue);
	}
	
	private void findMinNoOfCoins(Integer[] coinsDenomination, int inputValue){
		int countNoOfCoins=0;
		int initVal=inputValue;
		Arrays.sort(coinsDenomination, Collections.reverseOrder());//sort in descending order
		for(int value:coinsDenomination){
			while(initVal>=value){
				countNoOfCoins++;
				System.out.println(value);
				initVal=initVal-value;
			}
		}
		System.out.println("No. of coins = "+ countNoOfCoins);
	}
}