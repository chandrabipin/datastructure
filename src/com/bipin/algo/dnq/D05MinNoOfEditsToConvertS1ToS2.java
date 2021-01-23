package com.bipin.algo.dnq;

import java.util.*;

public class D05MinNoOfEditsToConvertS1ToS2{
	public static void main(String[] args){
		//input
		String s1 = "catch";
		String s2 = "carsh";
		char[] charS1 = s1.toCharArray();
		char[] charS2 = s2.toCharArray();
		D05MinNoOfEditsToConvertS1ToS2 d = new D05MinNoOfEditsToConvertS1ToS2();
		int result = d.calculateMinNoOfEditsToConvertS1ToS2(charS1, charS2, 0, 0);
		System.out.println(result);
	}
	
	// For edits there are three given valid operations
	// Insert -
	// Delete -
	// Replace -
	// i.e. at each steps we have three options to perform and based on that we get the min count.
	// We divide the problem into three parts based on these three operations.
	private int calculateMinNoOfEditsToConvertS1ToS2(char[] charS1, char[] charS2, int currentIndexOfCharS1, int currentIndexOfCharS2){
		//base condition. Remember it
		if(currentIndexOfCharS1 > charS1.length-1){// If s1 index is more than the last index. Just delete all the remaining chars in s2.
			return (charS2.length)-currentIndexOfCharS2;//number of delete operations for s2. 
		}
		if(currentIndexOfCharS2 > charS2.length-1){// If index is more than the last index. Just insert remaining s1 chars to s2.
			return (charS1.length)-currentIndexOfCharS1;//number of insert operations for s2. 
		}
		
		if(charS1[currentIndexOfCharS1] == (charS2[currentIndexOfCharS2])){
			return calculateMinNoOfEditsToConvertS1ToS2(charS1, charS2, currentIndexOfCharS1+1, currentIndexOfCharS2+1);//No operation
		}else{
			//Insert in s1.
			int op1 = 1 + calculateMinNoOfEditsToConvertS1ToS2(charS1, charS2, currentIndexOfCharS1+1, currentIndexOfCharS2);
			//Delete in s1.
			int op2 = 1 + calculateMinNoOfEditsToConvertS1ToS2(charS1, charS2, currentIndexOfCharS1, currentIndexOfCharS2+1);
			//Replace in s1 with s2.
			int op3 = 1 + calculateMinNoOfEditsToConvertS1ToS2(charS1, charS2, currentIndexOfCharS1+1, currentIndexOfCharS2+1);
			return Math.min(op1, Math.min(op2,op3));
		}
	}
}