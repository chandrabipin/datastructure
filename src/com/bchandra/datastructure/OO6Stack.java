package com.bchandra.datastructure;

public class OO6Stack {

	public static void main(String args[]) {
		OO6Stack stack = new OO6Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);

		System.out.println("PEEK:"+stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println("PEEK:"+stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println("PEEK:"+stack.peek());

		stack.deleteEntireStack();
		
	}
	
	/**
	 * create using single Linked List
	 * push
	 * pop
	 * peek
	 * delete
	 * 
	 * 
	 */
	OO2SingleLinkedListNode head = null;// tail is not required.
	
	private void push(int aValue) {
		OO2SingleLinkedListNode newNode = new OO2SingleLinkedListNode();
		newNode.setValue(aValue);
		if(head == null) {// inserting First Node
			newNode.setNext(null);
			head = newNode;
		}else {//insert new node at start position. i.e. 0th position
			newNode.setNext(head);
			head = newNode;			
		}
	}
	
	private int pop() {
		if(head == null) return -1;
		OO2SingleLinkedListNode tempNode = null;
		tempNode = head;
		if(head.getNext() != null) {//only one node
			head = head.getNext();
		} else {
			head=null;
		}
		return tempNode.getValue();
	}
	
	private int peek() {
		if(head == null) return -1;
		return head.getValue();		
	}
	
	private void deleteEntireStack() {
		head = null;// all other references will be deleted subsequently using gc.
		System.out.println("Delete entire Stack.");
	}
}

