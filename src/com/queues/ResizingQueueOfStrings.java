/*
 * File: ResizingQueueOfStrings.java
 * Date: 24 Sept, 2012
 * Last Modified: 2 Feb, 2013
 * Author: Ashish Chopra
 * ----------------------------------------------
 * 
 * 1. This structure is free from leaking out the implementation
 *    details through client API.
 * 2. It is still used to store "String" items.
 * 3. The queue is resized on certain time in its whole usage cycle due to
 *    which the amortized complexity of is O(N).
 *    
 */
package com.queues;

import java.util.NoSuchElementException;

/**
 * ResizingQueueOfStrings is a queue data structure developed to store
 * String items in first-in-first-out principle. It supports enqueue operation
 * to insert a string item and dequeue to remove the item from the queue.
 * 
 * @author Ashish Chopra
 * @version 1.0
 */
public class ResizingQueueOfStrings {

	private String items[];
	private int head;
	private int tail;
	
	/**
	 * constructs the queue object.
	 * 
	 */
	public ResizingQueueOfStrings() {
		items = new String[1];
		head = tail = 0;
	}
	
	/**
	 * inserts a string item into the queue.
	 * @param item
	 */
	public void enqueue(String item) {
		if (tail == items.length) resize(2 * items.length);
		items[tail++] = item;
	}
	
	/**
	 * removes the string from the queue.
	 * @return
	 */
	public String dequeue() {
		if(isEmpty()) 
			throw new NoSuchElementException("No element is present in queue");
		String item = items[head];
		items[head++] = null;
		return item;
	}
	
	/**
	 * checks to see if queue is empty.
	 * @return true if no element is in the queue, false otherwise.
	 */
	public boolean isEmpty() {
		return tail == head;
	}
	
	
	private void resize(int size) {
		String[] newItems = new String[size];
		int i = head, j = 0;
		while (i < tail) {
			newItems[j++] = items[i++];
		}
		items = newItems;
		head = 0;
		tail = j;
	}
}
