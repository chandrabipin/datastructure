package com.bchandra.datastructure;

public class OO7Queue {

	public static void main(String[] args) {
		OO7Queue queue = new OO7Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		queue.deleteEntireQueue();
}

	/**
	 * Implement queue using linked list. i.e enqueue at 0th position and dequeue from last position
	 * enqueue
	 * dequeue
	 * delete entire queue
	 */
	
	OO2SingleLinkedListNode head = null;// to dequeue
	OO2SingleLinkedListNode tail = null;// to enqueu
	// Above is important i.e. which logic for dequeue and which for enqueue. You can not reverse it.
	// If you reverse it the order of dequeue wll become O(n) - as using tail to dequeue - you have to reach  'last but 1 location' i.e. will need traversal - O(n)
	
	
	public void enqueue(int aValue) {//at last
		OO2SingleLinkedListNode newNode = new OO2SingleLinkedListNode();
		newNode.setValue(aValue);
		if (head==null) {//insert at 0th pos
			newNode.setNext(null);
			head = newNode;
			tail = newNode;
		} else {//insert at last
			newNode.setNext(null);
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	
	public int dequeue() {//from start
		if(head == null)
			return -1;
		OO2SingleLinkedListNode tempNode = null;
		tempNode = head;
		head = head.getNext();
		return tempNode.getValue();
	}
	
	private void deleteEntireQueue() {
		head=null;
		tail=null;
		System.out.println("Deleted entire Queue");
	}
}
