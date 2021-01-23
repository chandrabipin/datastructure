package com.bipin.algo.dnq;

import java.util.*;

public class D09LongestPalindromicSubstring{
	public static void main(String[] args){
		//input
		String str = "CABCCBUAC";//
		char[] charStr = str.toCharArray();

		D09LongestPalindromicSubstring d = new D09LongestPalindromicSubstring();
		int result = d.getLongestPalindromicSubstring(charStr, 0, charStr.length-1);
		System.out.println(result);
	}
	
	//In subsequence you can delete a char
	//In Substring it has to be contiguos string i.e. can not delete a char at any place.
	private int getLongestPalindromicSubstring(char[] charStr, int currentIndex, int currentIndexInReverseOrder){
		//base condition
		if(currentIndex>currentIndexInReverseOrder){//processed half of the palindrome
			return 0;
		}
		
		if(currentIndex == currentIndexInReverseOrder){//if reaches in middle i.e just 1 substring found
			return 1;//Take that char i.e. middle char
		}
		
		// Iterate both the arrays and compare chars
		// Possible oprations at each step:
		// 1. Match found: 1 + move to next char for both the arrays
		//		1.1 If match is found then the whole of this substring should be palindrome.
		//		1.2 i.e length of palindrome will be length of this substring -> currentIndexInReverseOrder-currentIndex-1;
		//		1.3 Check if remaining substring is a palindrome.
		//
		// 2. Match not found: 
		//		2.1 Move 1 char from charStr and retain same char from reverseCharStr
		//		2.2 Move 1 char from reverseCharStr and retain same char from charStr
		int op1 = 0;
		if(charStr[currentIndex]==charStr[currentIndexInReverseOrder]){
			int length = 2+getLongestPalindromicSubstring(charStr, currentIndex+1, currentIndexInReverseOrder-1);
			if (length==(currentIndexInReverseOrder-currentIndex)+1){//length is (endindex-startindex)+1 i.e +1 as it starts from 0.
				op1=length;
			}
		}		
		int op2 = getLongestPalindromicSubstring(charStr, currentIndex+1, currentIndexInReverseOrder);
		int op3 = getLongestPalindromicSubstring(charStr, currentIndex, currentIndexInReverseOrder-1);

		return Math.max(op1, Math.max(op2, op3));
	}
}