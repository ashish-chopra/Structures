/*
 *  File: FixedCapacityStack.java
 *  Date Create: 23 Sept, 2012
 *  Last Modified: 2 Feb, 2013 
 *  Author: Ashish Chopra
 *  ---------------------------------------------------
 *  
 * Merits:
 * 
 * 1. Use of array removes the burden of high memory usage as in 
 *    case of list based stack.
 * 2. Accessing array is more easy than accessing link strucutre.
 * 3. Every access operation is O(1), constant time.
 * 
 * De-Merits:
 * 
 * 1. The details of implementation is exposed through interface, as 
 *    asking the user to provide capacity of stack array.
 * 2. Does not deal with the case of Overflow (when stack moves ahead of capacity)
 *    and stack underflow (when stack moves to negative location) 
 * 3. What happens to the data entered when stack is full.
 * 4. Stack capacity is a limiting factor for real world applications.
 * 
 */
package com.stacks;

/**
 * FixedCapacityStack is another implementation of elementary
 * data structure called stack using arrays. In order to determine
 * the size of the array, we ask user for the capacity. This is one
 * of the defect of this class; leaking the implementation details via
 * interface.
 * 
 * @author Ashish Chopra
 * @version 1.0
 *
 */
public class FixedCapacityStackOfStrings {

	private String[] stack;
	private int N;
	
	/**
	 * constructs the object.
	 * @param capacity the fixed size of the stack object.
	 */
	public FixedCapacityStackOfStrings(int capacity) {
		stack = new String[capacity];
		N = 0;
	}
	
	/**
	 * pushes a string into the stack.
	 * @param item Item to be stored in stack as <code>String</code>.
	 */
	public void push(String item) {
		stack[N++] = item;
	}
	
	/**
	 * pops the most recently pushed item from the stack.
	 * @return the item from Stack as <code>String</code>.
	 * 
	 */
	public String pop() {
		String item = stack[--N];
		return item;
	}
	
	/**
	 * returns the current occuppied size of the stack.
	 * @return the size as <code>int</code>.
	 * 
	 */
	public int size() {
		return N;
	}
	
	/**
	 * checks to see if the stack is empty
	 * @return <code>true</code> if empty, <code>false</code> otherwise.
	 * 
	 */
	public boolean isEmpty() {
		return N == 0;
	}
}
