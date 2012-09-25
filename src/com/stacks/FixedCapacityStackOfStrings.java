/*
 *  File: FixedCapacityStack.java
 *  Date: 23 Sept, 2012
 *  Author: Ashish Chopra
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

/*
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
public class FixedCapacityStackOfStrings {

	private String[] stack;
	private int N;
	
	public FixedCapacityStackOfStrings(int capacity) {
		stack = new String[capacity];
		N = 0;
	}
	
	public void push(String item) {
		stack[N++] = item;
	}
	
	public String pop() {
		String item = stack[--N];
		return item;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
}
