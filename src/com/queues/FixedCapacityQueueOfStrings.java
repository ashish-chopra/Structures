/*
 *  File: FixedCapacityQueueOfStrings.java
 *  Date: 24 Sept, 2012
 *  Author: Ashish Chopra
 * ----------------------------------------------
 * 
 * 1. Queue is implemented using arrays.
 * 2. Due to fixed capacity nature of arrays, the implementation
 *    details are exposed via client APIs.
 * 3. It implements NoSuchElementException to handle the case of 
 *    queue underflow.
 * 4. The running time complexity is O(1) and memory usage is also less
 *    as compared to list based implementation of queues.
 * 
 */

package com.queues;

import java.util.NoSuchElementException;

/**
 * FixedCapacityQueueOfStrings is a queue data structure to 
 * store string elements.
 * @author Ashish Chopra
 *
 */
public class FixedCapacityQueueOfStrings {

	private String[] items;
	private int tail;
	private int head;
	
	/**
	 * constructs the object.
	 * @param capacity initial capacity of the data structure.
	 */
	public FixedCapacityQueueOfStrings(int capacity) {
		items = new String[capacity];
		tail = head = 0;
	}
	
	/**
	 * inserts an item into the queue at the end.
	 * @param item a String element added to the queue.
	 */
	public void enqueue(String item) {
		items[tail++] = item;
	}
	
	/**
	 * removes an element from the queue from the front.
	 * @return a String element from the queue.
	 */
	public String dequeue() {
		if(isEmpty())
			throw new NoSuchElementException("No element in queue");
		String item = items[head];
		items[head++] = null;
		return item;
	}
	
	/**
	 * checks to see if queue is empty.
	 * @return true if queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return tail == head ;
	}
	
}
