package com.bipin.algo.dnq;

public class S01Factorial{

// n! = n*(n-1)!
	public static void main(String[] args){
		S01Factorial f = new S01Factorial();
		int fact=f.calculateFactorial(Integer.parseInt(args[0]));
		System.out.println(fact);
	}

	private int calculateFactorial(int n){
		if(n==0) return 1;
		else if(n==1) return 1;
		else return (n*calculateFactorial(n-1));
	}
}