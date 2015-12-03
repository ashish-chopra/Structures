/*
 *  File: StackWithMiddle.java
 *  Author: Ashish Chopra
 *  Date: 27 May, 2015
 *  --------------------------------------------------
 *  Design a stack data structure which performs its operations
 *  in O(1) time complexity. It also consists of middle operations like
 *  deleteMiddle() and findMiddle() which is also performed at O(1) time
 *  complexity.
 *  
 */
package com.stacks;

/**
 * StackWithMiddle is an elementary stack data structure
 * with additional middle operations like findMiddle and 
 * deleteMiddle.
 * 
 * @author Ashish Chopra
 *
 */
public class StackWithMiddle<Item> {

	private Node top;
	private Node middle;
	private int N;
	
	public StackWithMiddle() {
		N = 0;
		top = null;
		middle = null;
	}
	
	/**
	 * returns the current size of the stack.
	 * @return size as <ode>int</code>.
	 */
	public int size() {
		return N;
	}
	
	/**
	 * checks to see if stack is empty.
	 * returns true if yes, false otherwise.
	 */
	public boolean isEmpty() {
		return top == null;
	}
	
	/**
	 * Inserts an item onto the stack and increments
	 * the top pointer.<br/>
	 * It also re-calculates the middle pointer location.
	 * 
	 * @param item an item to be inserted onto the stack
	 */
	public void push(Item item) {
		
		Node n = new Node(item, top, null);
		top.prev = n;
		top = n;
		N++;
		
		if (size() == 1) {
			middle = top;
		} else if (isEven(size())) {
			middle = middle.prev;
		} 
	}
	
	/*
	 * determines if the given number is even.
	 * returns true if yes, false otherwise.
	 */
	private boolean isEven(int num) {
		return num %2 == 0;
	}
	
	/**
	 * pops an item from the stack if available.
	 * returns an item if present, null otherwise.
	 * 
	 * @return
	 */
	public Item pop() {
		if (isEmpty()) 
			return null;
		Node n = top;
		top = top.next;
		top.prev = null;
		N--;
		
		if (isEmpty()) {
			middle = null;
		} else if (isEven(size())) {
			middle = middle.next;
		}
		return n.data;
	}
	
	/**
	 * peeks the middle element of the stack
	 * without deleting it from the stack.
	 * @return element as Item.
	 */
	public Item findMiddle() {
		return middle != null ? middle.data : null;
	}
	
	/**
	 * deletes the middle element of the stack and 
	 * re-adjust the middle after it.
	 * @return
	 */
	public Item deleteMiddle() {
		if (middle == null) 
			return null;
		Item item = middle.data;
		middle.prev = middle.next;
		N--;
		return item;
	}
	/**
	 * Node representation of each item of stack
	 * @author Ashish Chopra
	 *
	 */
	private class Node {
		Item data;
		Node next;
		Node prev;
		
		Node(Item data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
}
