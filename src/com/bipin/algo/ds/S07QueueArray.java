package com.bipin.algo.ds;

public class S07QueueArray{
	
	int arr[] = new int[10];
	
	//initialize the pointers
	int start = -1;
	int end = -1;
	public static void main(String[] a){
		//Queue opertaion
		//enqueue
		//dequeue
		S07QueueArray s = new S07QueueArray();
		s.enqueue(10);
		s.enqueue(20);
		s.enqueue(30);
		s.enqueue(40);
		s.dequeue();
		s.dequeue();
		s.dequeue();
		s.dequeue();
		s.dequeue();
	}
	
	private void enqueue(int num){
		arr[end+1]=num;
		end=end+1;
	}

	private void dequeue(){
		System.out.println(arr[start+1]);
		start=start+1;
	}


}