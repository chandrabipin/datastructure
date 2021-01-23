package com.bipin.algo.generic;

public class S03FindLargestNumberInAnArray{
	
	public static void main(String[] args){
		int[] intArr = new int[args.length];
		for(int i = 0; i<args.length;i++){
			intArr[i]=Integer.parseInt(args[i]);
		}
		S03FindLargestNumberInAnArray s = new S03FindLargestNumberInAnArray();
		int greatestNum = s.findGreatestNumberInArray(intArr);
		System.out.println(greatestNum);
	}
	
	private int findGreatestNumberInArray(int[] intArr){
		int greatestNum=intArr[0];
		for(int i = 1; i<intArr.length;i++){
			if(greatestNum<intArr[i]){
				greatestNum=intArr[i];
			}
		}
		return greatestNum;
	}

}