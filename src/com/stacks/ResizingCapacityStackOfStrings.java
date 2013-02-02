/*
 * File: ResizingCapacityStackOfStrings.java
 * Date: 24 Sept, 2012
 * Author: Ashish Chopra
 * ---------------------------------------------------------------------
 * Features and defects:
 *  
 * 1. Still it is a stack of Strings.
 * 2. We double up the stack size whenever the stack reaches the full. 
 *    This exponentially increase the size of stack.
 * 3. The amortized analysis of the time complexity is O(N) / N = O(1).
 * 4. The memory usage is also efficient than link based structure.
 * 5. On pop operation, the size of stack is reduced to half when the stack
 *    filling goes to 1/4 of the size.
 * 6. Boundary cases for underflow and overflow are not handled properly.
 * 
 */
package com.stacks;

/**
 * ResizingCapacityStackOfStrings is a stack implementation using
 * resizale arrays. This removes the defect of earlier implementation which
 * leaks the details through the interface/ API.
 * 
 * @author Ashish Chopra
 * @version 1.0
 */
public class ResizingCapacityStackOfStrings {

	private String[] items;
	private int N;
	
	public ResizingCapacityStackOfStrings() {
		items = new String[1];
		N = 0;
	}
	
	public void push(String s) {
		if (N == items.length) 
			resize(2 * items.length);
		items[N++] = s;
	}
	
	public String pop() {
		if (N > 0 && N == items.length / 4) 
			resize(items.length / 2);
		String s = items[--N];
		items[N] = null;
		return s;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	private void resize(int size) {
		String[] newItems = new String[size];
		for (int i = 0; i< N; i++) {
			newItems[i] = items[i];
		}
		items = newItems;
	}
}
