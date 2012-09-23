/*
 *  File: StackOfStrings.java
 *  Date: 23 Spet, 2012
 *  Author : Ashish Chopra
 *  
 */
package com.stacks;

/**
 * 
 * StackOfStrings is a implementation of elmentary data structure
 * called <em>Stacks</em>, which is used to store items of String 
 * type. 
 * 
 * @author Ashish Chopra
 * @version 1.0
 */
public class StackOfStrings {

	private Node first = null;
	
	private class Node {
		String item;
		Node next;
	}
	
	/**
	 * pushes a new item onto the stack.
	 * @param item a item as String to be added.
	 */
	public void push(String item) {
		
		Node oldfirst = first;
		Node node = new Node();
		node.item = item;
		node.next = oldfirst;
		first = node;
	}
	
	/**
	 * returns the top item of the stack and remove it.
	 * @return most recent item inserted in the stack.
	 */
	public String pop() {
		String item  = first.item;
		first = first.next;
		return item;
	}

	/**
	 * checks to see if stack is empty.
	 * @return true if stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	
	/**
	 * returns the size of the stack.
	 * @return number of items currently in the stack.
	 */
	public int size() {
		Node node = first;
		int count = 0;
		
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	
}
