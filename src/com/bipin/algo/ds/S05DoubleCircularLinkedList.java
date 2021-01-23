package com.bipin.algo.ds;

public class S05DoubleCircularLinkedList{
	
	// Type of linked lists are - 
	// Single Linked List
	// Circular Single Linked List
	// Double LInked List
	// Circular Double LInked List
	// We will learn only the most complex, the last one. All other can be done with same concept.
	
	// Create a Node class with previous, next and value.
	
	//01 Create a blank/empty DoubleCircularLinkedList
	S05Node head = null;
	S05Node tail = null;

	public static void main(String[] args){
		//01 Create a blank/empty DoubleCircularLinkedList
			//Create Head and Tail with null reference
		//02 Insert a node [start, end or in between]
			//Create first node
			//Update Head and Tail with this node's reference
			//And so on
		//03 Traverse/Reverse Traverse/ Search
		//04 Delete a node or entire DoubleCircularLinkedList
		
		//02 Insert a node
		S05DoubleCircularLinkedList dcll = new S05DoubleCircularLinkedList();
		S05Node node1 = new S05Node(10);
		dcll.insert(node1);
		S05Node node2 = new S05Node(20);
		dcll.insert(node2);
		S05Node node3 = new S05Node(30);
		dcll.insert(node3);
		S05Node node4 = new S05Node(40);
		dcll.insert(node4);
		S05Node node5 = new S05Node(50);
		dcll.insert(node5);
		dcll.traverse();
		dcll.deleteLL();
		dcll.traverse();
	}
	
	//insert at first location
	private void insert(S05Node node){
		insert(node, 0);
	}

	private void insert(S05Node node, String last){
		//[Last element in LL]
		tail.setNext(node);
		node.setPrevious(tail);
		tail=node;
		node.setNext(head);
		head.setPrevious(tail);
	}

	private void insert(S05Node node, int insertLocation){
		System.out.println("insert:"+node.getValue());
		//[START of the LL]
		if(insertLocation == 0 && head == null && tail == null){//insert a new node into empty LinkedList 
			head = node;
			tail = node;
			node.setPrevious(node);
			node.setNext(node);
		}
		//[START of the LL]
		else if(insertLocation == 0 && head != null && tail != null){//insert a new node at first location in a non empty LinkedList. 
			node.setNext(head);
			node.setPrevious(tail);
			head=node;
			tail.setNext(head);
		}
		//[at location insertLocation in LL  0,1,2,.....n]
		else {
			//iterate through LL starting from 0 to (insertLocation-1) location
			//stop at insertLocation-2 (one node previous to the insertLocation)and insert
			S05Node currNode=head;
			for(int i=0; i< insertLocation-2;i++){
				currNode=currNode.getNext();
			}
			node.setPrevious(currNode);
			node.setNext(currNode.getNext());
			currNode.setNext(node);
			node.getNext().setPrevious(node);
		}

	}
	
	private void traverse(){
		S05Node currNode = head;
		//System.out.println(currNode.getNext().getValue());
		while(currNode!=tail){
			System.out.println("traverse:"+currNode.getValue());
			currNode = currNode.getNext();
		}
		if(currNode!=null)
			System.out.println("traverse:"+currNode.getValue());
		else
		System.out.println("traverse  currNode:"+currNode);
	}
	
	private void deleteLL(){
		head = null;
		tail = null;
	}
	
}