package com.bipin.algo.dynamic;

import java.util.*;

public class DP01Fibonacci{
	public static void main(String[] args){
		//input
		int n = 11;//find 10th number ins the series
		int[] memoize = new int[n+1];// including 0! hence +1
		DP01Fibonacci dp = new DP01Fibonacci();
		int result = dp.calculateFibonacci(memoize, n);
		System.out.println(result);
		int resultBU = dp.calculateFibonacciBottomUp(memoize, n);
		System.out.println(resultBU);
	}
	
	private int calculateFibonacci(int[] memoize, int n){
		//base condition
		if(n<0) return -1;
		if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 1;
		
		if(memoize[n]==0){
			memoize[n]=calculateFibonacci(memoize, n-1)+calculateFibonacci(memoize, n-2);
		}
		return memoize[n];

	}
	
	private int calculateFibonacciBottomUp(int[] memoize, int n){
		//base condition
		if(n<0) return -1;
		if(n==0) return 0;
		if(n==1) return 1;
		
		if(memoize[n]==0){
			for(int i=2;i<=n;i++){
				memoize[n]=(i-1)+(i-2);
			}
		}
		return memoize[n];

	}
	
}