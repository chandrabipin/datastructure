package com.bipin.algo.ds;

public class S06StackArray{

	int[] arr = new int[10];
	int top =-1;
	public static void main(String[] args){
		//Operations
		//Push, Pop, Delete
		S06StackArray s =new S06StackArray();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
	}
	
	
	private void push(int num){
		arr[top+1]=num;
		top=top+1;
	}
	
	private void pop(){
		System.out.println(arr[top]);
		top=top-1;
	}
}