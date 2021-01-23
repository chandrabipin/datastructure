package com.bipin.algo.dnq;

import java.util.*;

public class D03FindNoOfWaysToCreateN {
	public static void main(String[] args){
		//input
		int[] factors = {1,3,4};
		//int testValue = 4;//Ans: {(1,3), (3,1), (1,1,1,1,1), (4)}
		int testValue = 5;//Ans: {(1,3,1), (3,1,1), (1,1,3), (1,1,1,1,1,1), (4,1), (1,4)}
		
		D03FindNoOfWaysToCreateN d = new D03FindNoOfWaysToCreateN();
		int n = d.findNoOfWaysToCreateN(factors, testValue);
		System.out.println(n);
	}
	
	/**
	* Biggest challenge is to break it in similar subproblem
	* input {1,3,4} and value =5.
	* Formula: 
	* 	Find how many ways we can create (5-1) ~ 4. i.e. (1,1,1,1) , (1,3) , (3,1) , (4)
	* 		And then add 1 to the final list i.e. (1,1,1,1,1) , (1,3,1) , (3,1,1) , (4,1)
	*	Find how many ways we can create (5-3) ~ 2. (1,1)
	* 		And then add 3 to the final list i.e. (1,1,3)
	*	Find how many ways we can create (5-4) ~ 1. (1)
	* 		And then add 4 to the final list i.e. (1,4)
	* Final Answer for how many ways we can create 5 => {(1,1,1,1,1) , (1,3,1) , (3,1,1) , (4,1), (1,1,3), (1,4)}
	*
	*
	*
	*	Value =4:
	* 	Find how many ways we can create (4-1) ~ 3. i.e. (1,1,1) , (3)
	* 		And then add 1 to the final list i.e. (1,1,1,1) , (3,1)
	*	Find how many ways we can create (4-3) ~ 1. (1)
	* 		And then add 3 to the final list i.e. (1,3)
	*	Find how many ways we can create (4-4) ~ 0. ()
	* 		And then add 4 to the final list i.e. (4)
	* Final Answer for how many ways we can create 4 => {(1,1,1,1) , (3,1), (1,3)  , (4)}
	*
	*
	* This is Divide and conquer problem because we diving it in three subproblems and then solve each subproblem to get the final solution
	*/
	private int findNoOfWaysToCreateN(int[] factors, int testValue){
		
		//For Base condition there will not be any recursion calls
		if(testValue<=0){//Exit criteria, hence very important
			return 1;// only 1 way to create 0 i.e. {}
		}
		if(testValue==1){
			return 1;// only 1 way to create 1 i.e {1}
		}
		if(testValue==2){
			return 1;// only 1 way to create 2 i.e {1,1}
		}
		if(testValue==3){
			return 2;// only 2 ways to create 3 i.e {1,1,1} {3}
		}
		
		//If testValue is more than 3 use below recursion formula
		return findNoOfWaysToCreateN(factors,testValue-1)+findNoOfWaysToCreateN(factors,testValue-3)+findNoOfWaysToCreateN(factors,testValue-4);
		
		
	}
}