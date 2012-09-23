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
public class FixedCapacityStackOfStrings {

	private String[] stack;
	private int index;
	
	public FixedCapacityStackOfStrings(int capacity) {
		stack = new String[capacity];
		index = 0;
	}
	
	public void push(String item) {
		stack[index++] = item;
	}
	
	public String pop() {
		String item = stack[--index];
		return item;
	}
	
	public int size() {
		return index;
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
}
