package com.bipin.algo.ds;


public class S05Node{
	S05Node previous = null;// note these are object and not int
	S05Node next = null;// note these are object and not int
	int value = -1;
	
	S05Node(S05Node previous, S05Node next, int value){
		this.previous=previous;
		this.next=next;
		this.value=value;
	}
	
	S05Node(int value){
		this.value=value;
	}

	public S05Node getPrevious(){
		return previous;
	}
	public S05Node getNext(){
		return next;
	}
	public int getValue(){
		return value;
	}

	public void setPrevious(S05Node previous){
		this.previous=previous;
	}
	public void setNext(S05Node next){
		this.next=next;
	}
	public void setValue(int value){
		this.value=value;
	}

}