package com.bchandra.datastructure;

public class OO5CircularDoubleLinkedListNode {

	private OO5CircularDoubleLinkedListNode next = null;
	private OO5CircularDoubleLinkedListNode previous = null;
	private Integer value = null;
	/**
	 * @return the next
	 */
	public OO5CircularDoubleLinkedListNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(OO5CircularDoubleLinkedListNode next) {
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
	public OO5CircularDoubleLinkedListNode getPrevious() {
		return previous;
	}
	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(OO5CircularDoubleLinkedListNode previous) {
		this.previous = previous;
	}
}
