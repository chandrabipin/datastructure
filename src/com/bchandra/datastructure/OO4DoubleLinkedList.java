package com.bchandra.datastructure;

public class OO4DoubleLinkedList {

	public static void main(String[] args) {
		OO4DoubleLinkedList linkedList = new OO4DoubleLinkedList();
		linkedList.createFirstNodeInLinkedList(10);
		linkedList.traverseDoubleLinkedList();
		linkedList.insert(20, 0);
		linkedList.insert(25, 0);
		linkedList.insert(30, 0);
		linkedList.insert(40, 0);
		System.out.println("-------------------------");
		linkedList.traverseDoubleLinkedList();
		linkedList.insert(50, linkedList.last);
		System.out.println("-------------------------");
		linkedList.traverseDoubleLinkedList();
		linkedList.insert(60, 2);
		System.out.println("-------------------------");
		linkedList.traverseDoubleLinkedList();
		System.out.println("-------------------------");
		linkedList.traverseReverseDoubleLinkedList();
		System.out.println("-----Delete 1--------------------");
		linkedList.deleteNode(0);
		linkedList.traverseDoubleLinkedList();
		System.out.println("-----Delete 2--------------------");
		linkedList.deleteNode(linkedList.last);
		linkedList.traverseDoubleLinkedList();
		System.out.println("-----Delete 3--------------------");
		linkedList.deleteNode(2);
		linkedList.traverseDoubleLinkedList();
		System.out.println("------Delete 4-------------------");
		linkedList.deleteEntireLinkedList();
		linkedList.traverseDoubleLinkedList();
		System.out.println("----------LL Deleted---------------");

	}
	
	//Create a blank Double linked list
	OO4DoubleLinkedListNode head = null;
	OO4DoubleLinkedListNode tail = null;
	int last = -1;
	/**
	 * create a blank node and set its value.
	 * update its reference
	 */
	private void createFirstNodeInLinkedList(int nodeValue) {
		OO4DoubleLinkedListNode node = new OO4DoubleLinkedListNode();
		node.setValue(nodeValue);
		node.setNext(null);
		node.setPrevious(null);
		
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
			OO4DoubleLinkedListNode node1 = new OO4DoubleLinkedListNode();
			node1.setValue(nodeValue);
			node1.setNext(head);
			node1.setPrevious(null);

			head.setPrevious(node1);
			head = node1;
			last++;
		} else if (location == last) {
			OO4DoubleLinkedListNode node2 = new OO4DoubleLinkedListNode();
			node2.setValue(nodeValue);
			node2.setNext(null);
			node2.setPrevious(tail);

			tail.setNext(node2);
			
			tail = node2;	
			last++;
		} else {
			OO4DoubleLinkedListNode currNode = null;
			for(int i=0;i<location;i++) {//stop a node before
				if (i==0)
					currNode = head;
				else
					currNode = currNode.getNext();
			}
			OO4DoubleLinkedListNode node3 = new OO4DoubleLinkedListNode();
			node3.setValue(nodeValue);
			node3.setNext(currNode.getNext());
			node3.setPrevious(currNode);

			currNode.getNext().setPrevious(node3);
			currNode.setNext(node3);
			
			last++;
		}
	}
	
	private void traverseDoubleLinkedList() {
		if(head == null) {
			System.out.println("OO4DoubleLinkedList.traverseDoubleLinkedList(): Empty");
			return;
		}
		OO4DoubleLinkedListNode currNode = head;//startingnode
		//System.out.println("OO4DoubleLinkedList.travelDoubleLinkedList(): 1:" + currNode.getValue());
		while(currNode!=tail) {
			System.out.println("OO4DoubleLinkedList.travelDoubleLinkedList(): " + currNode.getValue());
			currNode = currNode.getNext();
			//if(currNode==null) break;
		}
		//Print if currNode=tail
		System.out.println("OO4DoubleLinkedList.travelDoubleLinkedList(): " + currNode.getValue());
	}
	private void traverseReverseDoubleLinkedList() {
		OO4DoubleLinkedListNode currNode = tail;//startingnode
		//System.out.println("OO4DoubleLinkedList.travelDoubleLinkedList(): 1:" + currNode.getValue());
		while(currNode!=head) {
			System.out.println("OO4DoubleLinkedList.travelDoubleLinkedList(): " + currNode.getValue());
			currNode = currNode.getPrevious();
			//if(currNode==null) break;
		}
		//Print if currNode=tail
		System.out.println("OO4DoubleLinkedList.travelDoubleLinkedList(): " + currNode.getValue());
	}

	private void deleteNode(int location) {
		if(location == 0) {
			if(last==0) {//only one node
				head = null;
				tail = null;
			} else {
				head=head.getNext();
				head.setPrevious(null);//new head's previous value
			}
			last--;
		} else if (location == last) {
			OO4DoubleLinkedListNode currNode =null;
			for (int i = 0; i < last-1; i++) {//navigate to last but 2 i.e. last-2. Since then you will get next node of it which will be (last-1)the node.
				if (i==0)
					currNode = head;
				else if (i != last-1)
					currNode = currNode.getNext();
			}
			currNode.setNext(null);
			tail = currNode;
			last--;
		} else {
			OO4DoubleLinkedListNode currNode = null;
			for (int i = 0; i < location; i++) {//navigate to last but two
				if (i==0)
					currNode = head;
				else 
					currNode = currNode.getNext();
			}
			currNode.getNext().getNext().setPrevious(currNode);
			currNode.setNext(currNode.getNext().getNext());
			last--;
		}
	}
	
	private void deleteEntireLinkedList() {
		// make all previous ref to null
		OO4DoubleLinkedListNode currNode = null;
		System.out.println("OO4DoubleLinkedList.deleteEntireLinkedList(): last:"+ last);
		for(int i = 0; i<last-1;i++) {
			if (i==0)
				currNode = head;
			else 
				currNode = currNode.getNext();
			System.out.println("i:"+i);
			currNode.setPrevious(null);
		}
		
		//then this
		head = null;
		tail = null;
	}
}
