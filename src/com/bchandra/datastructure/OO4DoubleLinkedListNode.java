package com.bchandra.datastructure;

public class OO4DoubleLinkedListNode {

	private OO4DoubleLinkedListNode next = null;
	private OO4DoubleLinkedListNode previous = null;
	private Integer value = null;
	/**
	 * @return the next
	 */
	public OO4DoubleLinkedListNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(OO4DoubleLinkedListNode next) {
		this.next = next;
	}
	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	/**
	 * @return the previous
	 */
	public OO4DoubleLinkedListNode getPrevious() {
		return previous;
	}
	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(OO4DoubleLinkedListNode previous) {
		this.previous = previous;
	}
}
