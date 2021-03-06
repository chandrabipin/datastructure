package com.bchandra.datastructure;

public class OO3CircularSingleLinkedList {

	public static void main(String[] args) {
		OO3CircularSingleLinkedList linkedList = new OO3CircularSingleLinkedList();
		linkedList.createFirstNodeInLinkedList(10);
		linkedList.travelCircularSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.insert(20, 0);
		linkedList.insert(30, 0);
		linkedList.insert(40, 0);
		linkedList.travelCircularSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.insert(5, linkedList.last);
		linkedList.travelCircularSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.insert(60, 2);
		linkedList.insert(70, 3);
		linkedList.insert(80, 2);
		linkedList.travelCircularSingleLinkedList();
		System.out.println("-----------Delete--------------");
		linkedList.deleteNode(0);
		linkedList.travelCircularSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.deleteNode(linkedList.last);
		linkedList.travelCircularSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.deleteNode(3);
		linkedList.travelCircularSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.deleteEntireLinkedList();
		linkedList.travelCircularSingleLinkedList();
		System.out.println("----------LL Deleted---------------");

	}
	
	//Create a blank Single linked list
	OO3CircularSingleLinkedListNode head = null;
	OO3CircularSingleLinkedListNode tail = null;
	int last = -1;
	/**
	 * create a blank node and set its value.
	 * update its reference
	 * 
	 */
	private void createFirstNodeInLinkedList(int nodeValue) {

		// create a blank node
		OO3CircularSingleLinkedListNode node = new OO3CircularSingleLinkedListNode();
		node.setNext(node);//self

		//set its value
		node.setValue(nodeValue);
		
		//set reference
		head = node;
		tail = node;
		last++;
	}
	/**
	 * 01 insert at starting pos
	 */

	/**
	 * 02 insert at last pos
	 */

	/**
	 * 03 insert in between pos
	 */
	private void insert(int nodeValue, int location) {
		if(location == 0) {
			OO3CircularSingleLinkedListNode node1 = new OO3CircularSingleLinkedListNode();
			node1.setValue(nodeValue);
			node1.setNext(head);

			head = node1;
			tail.setNext(head);//i.e.new head
			last++;
		} else if (location == last) {
			OO3CircularSingleLinkedListNode node2 = new OO3CircularSingleLinkedListNode();
			node2.setValue(nodeValue);
			node2.setNext(head);

			tail.setNext(node2);
			tail = node2;	
			last++;
		} else {
			OO3CircularSingleLinkedListNode currNode = null;
			for(int i=0;i<location;i++) {// navigate to (location -1)th node
				if (i==0)
					currNode = head;
				else
					currNode = currNode.getNext();
			}
			OO3CircularSingleLinkedListNode node3 = new OO3CircularSingleLinkedListNode();
			node3.setValue(nodeValue);
			node3.setNext(currNode.getNext());
			
			currNode.setNext(node3);
			last++;
		}
	}
	
	private void travelCircularSingleLinkedList() {
		OO3CircularSingleLinkedListNode currNode = head; //starting node
		// System.out.println("OO3CircularSingleLinkedList.travelCircularSingleLinkedList(): 1:" + currNode.getValue());
		while(currNode != tail) {
			System.out.println("OO3CircularSingleLinkedList.travelCircularSingleLinkedList(): " + currNode.getValue());
			currNode = currNode.getNext();
			if(currNode==tail) {
				System.out.println("OO3CircularSingleLinkedList.travelCircularSingleLinkedList(): " + currNode.getValue());
				System.out.println("OO3CircularSingleLinkedList.travelCircularSingleLinkedList(): tail.next.value:" + currNode.getNext().getValue());
			}
		}
	}
	
	private void deleteNode(int location) {
		if(location == 0) {
			if(last==0) {//only one node
				head.setNext(null);
				head = null;
				tail = null;
			} else {
				head=head.getNext();
				tail.setNext(head);
			}
			last--;
		} else if (location == last) {
			OO3CircularSingleLinkedListNode currNode =null;
			for (int i = 0; i < last-1; i++) {//navigate to last but 2 i.e. last-2. Since then you will get next node of it which will be (last-1)the node.
				if (i==0)
					currNode = head;
				else if (i != last-1)
					currNode = currNode.getNext();
			}
			
			currNode.setNext(head);
			tail = currNode;
			last--;
		} else {
			OO3CircularSingleLinkedListNode currNode = null;
			for (int i = 0; i < location; i++) {//navigate to last but two
				if (i==0)
					currNode = head;
				else 
					currNode = currNode.getNext();
			}
			currNode.setNext(currNode.getNext().getNext());
			last--;
		}
	}
	
	private void deleteEntireLinkedList() {
		head = null;
		tail = null;
	}
}
