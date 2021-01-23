package com.bipin.algo.dnq;

public class S02Fibonacci{

	public static void main(String[] args){
		S02Fibonacci f = new S02Fibonacci();
		//find nth number in the series
		int nthNumber = f.findNthNumber(Integer.parseInt(args[0]));
		System.out.println(nthNumber);

	}
	
	private int findNthNumber(int n){
		if(n<=0)
			return -1;
		else if(n==1)
			return 0;
		else if (n==2)
			return 1;
		//f(n)=f(n-1)+f(n-2);
		else return findNthNumber(n-1)+findNthNumber(n-2);
	}
}