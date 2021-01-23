package com.bipin.algo.dnq;

import java.util.*;

public class D08LongestPalindromicSubsequence{
	public static void main(String[] args){
		//input
		String str = "AMEEWMEA";//"ELRMENMET";
		char[] charStr = str.toCharArray();

		D08LongestPalindromicSubsequence d = new D08LongestPalindromicSubsequence();
		int result = d.getLongestPalindromicSubsequence(charStr, 0, charStr.length-1);
		System.out.println(result);
	}
	
	private int getLongestPalindromicSubsequence(char[] charStr, int currentIndex, int currentIndexInReverseOrder){
		//base condition
		if(currentIndex>currentIndexInReverseOrder){//traverse only half
			return 0;
		}
		if(currentIndex==currentIndexInReverseOrder){//if reaches in middle i.e just 1 subsequence found
			return 1;
		}
		
		// Iterate both the arrays and compare chars
		// Possible oprations at each step:
		// 1. Match found: 1 + move to next char for both the arrays
		// 2. Match not found: 
		//		2.1 Delete 1 char from charStr and retain same char from reverseCharStr
		//		2.2 Delete 1 char from reverseCharStr and retain same char from charStr
		int op1=0;
		if(charStr[currentIndex]==charStr[currentIndexInReverseOrder]){
			op1= 2 + getLongestPalindromicSubsequence(charStr, currentIndex+1, currentIndexInReverseOrder-1);// 2 becuase 1 from front and 1 from backside.
		}
		int op2 = getLongestPalindromicSubsequence(charStr, currentIndex+1, currentIndexInReverseOrder);
		int op3 = getLongestPalindromicSubsequence(charStr, currentIndex, currentIndexInReverseOrder-1);
		return Math.max(op1,Math.max(op2,op3));

	}
}