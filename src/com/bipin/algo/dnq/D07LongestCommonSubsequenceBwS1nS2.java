package com.bipin.algo.dnq;

import java.util.*;

public class D07LongestCommonSubsequenceBwS1nS2{
	public static void main(String[] args){
		//input
		String s1 = "elephant";//"houdini"
		String s2 = "eretpat";//
		char[] s1Char = s1.toCharArray();
		char[] s2Char = s2.toCharArray();
		
		D07LongestCommonSubsequenceBwS1nS2 d = new D07LongestCommonSubsequenceBwS1nS2();
		int result = d.getLongestCommonSubsequence(s1Char, s2Char, 0, 0);
		System.out.println(result);
	}
	
	private int getLongestCommonSubsequence(char[] s1Char, char[] s2Char, int s1CurrentIndex, int s2CurrentIndex){
		//Base condition
		if(s1CurrentIndex > s1Char.length-1 || s2CurrentIndex > s2Char.length-1){
			return 0;
		}
		//So we have just two options
		//To delete a char or not to delete the char at particular location to get the common subsequence
		if(s1Char[s1CurrentIndex]==s2Char[s2CurrentIndex]){
			// Print the current char and move to next index
			//System.out.print(s1Char[s1CurrentIndex]);
			return 1 + getLongestCommonSubsequence(s1Char, s2Char, s1CurrentIndex+1, s2CurrentIndex+1);
		}else {
			// Else you have two options
			// Take Current char or
			// Delete Current char
			int op1 = getLongestCommonSubsequence(s1Char, s2Char, s1CurrentIndex+1, s2CurrentIndex);// I added +1 in starting which was wrong. If the char does not match we cant take it.
			// We either skip s1 to next index and retain s2's endex or we retain s1 and skip s2 to next char.
			int op2 = getLongestCommonSubsequence(s1Char, s2Char, s1CurrentIndex, s2CurrentIndex+1);
			return Math.max(op1, op2);
		}
		
	}
}