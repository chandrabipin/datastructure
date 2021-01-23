package com.bipin.algo.dynamic;

import java.util.*;

public class DP02FindNoOfWaysToCreateN{
	public static void main(String[] args){
		//input
		int[] factor = {1,3,4};
		int n = 5;
		int[] memoization = new int[n+1];// since n we use as index so add +1 to get that length
		DP02FindNoOfWaysToCreateN dp = new DP02FindNoOfWaysToCreateN();
		int result1 = dp.findNoOfWaysToCreateN(memoization, factor, n);
		System.out.println(result1);
		int result2 = dp.findNoOfWaysToCreateNBottomUp(memoization, factor, n);
		System.out.println(result2);
	}
	

	// how many way we can create 5-1~4  -> then add 1
	// how many way we can create 5-3~2  -> then add 3
	// how many way we can create 5-4~1  -> then add 4
	// 1 can be created 1 way {1}
	// 0 can be created 1 way {}
	// 2 can be created 1 way {1,1}
	// 3 can be created 2 way {1,1,1}, {3}
	// 4 can be created   way {1,1,1,1}, {1,3}, {3,1} {4}
	private int findNoOfWaysToCreateN(int[] memoization, int[] factor, int n){
		//base condition
		if(n<0) return 0;
		if(n==0) return 1;
		if(n==1) return 1;
		if(n==2) return 1;
		if(n==3) return 2;
		
		if (memoization[n]==0){
			int op1 = findNoOfWaysToCreateN(memoization, factor, n-1);
			int op2 = findNoOfWaysToCreateN(memoization, factor, n-3);
			int op3 = findNoOfWaysToCreateN(memoization, factor, n-4);
			memoization[n] = op1+op2+op3;
		}
		return memoization[n];
	}
	
	//Bottomup
	// 0,1,2,3  -> given
	//4 -> 2+1+1
	//5 -> 4+1+1
	private int findNoOfWaysToCreateNBottomUp(int[] memoization, int[] factor, int n){
		//base condition
		if(n<0) return 0;
		memoization[0] = 1;
		memoization[1] = 1;
		memoization[2] = 1;
		memoization[3] = 2;
		if (memoization[n]==0){
			for(int i=4;i<=n;i++){
				memoization[i] = memoization[i-1]+memoization[i-3]+memoization[i-4];
			}
		}
		return memoization[n];
	}
}