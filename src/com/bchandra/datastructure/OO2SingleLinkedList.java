package com.bchandra.datastructure;

public class OO2SingleLinkedList {

	public static void main(String[] args) {
		OO2SingleLinkedList linkedList = new OO2SingleLinkedList();
		linkedList.createFirstNodeInLinkedList(10);
		linkedList.travelSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.insert(20, 0);
		linkedList.insert(30, 0);
		linkedList.insert(40, 0);
		linkedList.travelSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.insert(5, linkedList.last);
		linkedList.travelSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.insert(60, 2);
		linkedList.insert(70, 3);
		linkedList.insert(80, 2);
		linkedList.travelSingleLinkedList();
		linkedList.searchLinkedList(10);
		System.out.println("-------------------------");
		linkedList.deleteNode(0);
		linkedList.travelSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.deleteNode(linkedList.last);
		linkedList.travelSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.deleteNode(3);
		linkedList.travelSingleLinkedList();
		System.out.println("-------------------------");
		linkedList.deleteEntireLinkedList();
		linkedList.travelSingleLinkedList();
		System.out.println("----------LL Deleted---------------");

	}
	
	//Create a blank Single linked list
	OO2SingleLinkedListNode head = null;
	OO2SingleLinkedListNode tail = null;
	int last = -1;
	/**
	 * create a blank node and set its value.
	 * update its reference
	 */
	private void createFirstNodeInLinkedList(int nodeValue) {
		OO2SingleLinkedListNode node = new OO2SingleLinkedListNode();
		node.setValue(nodeValue);
		node.setNext(null);
		
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
			OO2SingleLinkedListNode node1 = new OO2SingleLinkedListNode();
			node1.setValue(nodeValue);
			node1.setNext(head);

			head = node1;
			last++;
		} else if (location == last) {
			OO2SingleLinkedListNode node2 = new OO2SingleLinkedListNode();
			node2.setValue(nodeValue);
			node2.setNext(null);

			tail.setNext(node2);
			tail = node2;	
			last++;
		} else {
			OO2SingleLinkedListNode currNode = null;
			for(int i=0;i<location;i++) {
				if (i==0)
					currNode = head;
				else
					currNode = currNode.getNext();
			}
			OO2SingleLinkedListNode node3 = new OO2SingleLinkedListNode();
			node3.setValue(nodeValue);
			node3.setNext(currNode.getNext());
			currNode.setNext(node3);
			last++;
		}
	}
	
	private void travelSingleLinkedList() {
		OO2SingleLinkedListNode currNode = head;//startingnode
		//System.out.println("OO2SingleLinkedList.travelSingleLinkedList(): 1:" + currNode.getValue());
		while(currNode!=tail) {
			System.out.println("OO2SingleLinkedList.travelSingleLinkedList(): " + currNode.getValue());
			currNode = currNode.getNext();
			//if(currNode==null) break;
		}
	}
	
	private void deleteNode(int location) {
		if(location == 0) {
			if(last==0) {//only one node
				head = null;
				tail = null;
			} else {
				head=head.getNext();
			}
			last--;
		} else if (location == last) {
			OO2SingleLinkedListNode currNode =null;
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
			OO2SingleLinkedListNode currNode = null;

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
	
	private int searchLinkedList(int aValue) {
		OO2SingleLinkedListNode currNode = head;
		int searchIndex = -1;

		while(currNode != tail) {
			searchIndex++;
			if(currNode.getValue()==aValue) {
				System.out.println("OO2SingleLinkedList.searchLinkedList(): 1-Index:"+searchIndex);
			}
			currNode = currNode.getNext();
		}
		if (searchIndex==-1) System.out.println("OO2SingleLinkedList.searchLinkedList(): Index can note be found.");
		return searchIndex;
	}
}
