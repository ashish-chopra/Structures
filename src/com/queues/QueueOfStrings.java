/*
 *  File: QueueOfStrings.java
 *  Date: 24 Sept 2012
 *  Author: Ashish Chopra
 *  ----------------------------------------------
 *  QueueOfStrings is an abstract structure implements 
 *  for String type of elements to be stored in First-In-
 *  First-Out fashion.
 *  
 *  1. This class is only used for storing String types.
 *  2. It uses link list based implementation of storing items 
 *     in queue fashion.
 *  3. Valid Exceptions are not thrown for queue underflow condition.
 *  4. It does not provide an implementation of Iterator used for traversing
 *     over the elements.
 *  5. The running time of all operations are O(1).
 *  
 */

package com.queues;

/**
 * QueueOfStrings is a queue data structure designed
 * to store elements of String type.
 * 
 * @author Ashish Chopra
 *
 */
public class QueueOfStrings {

	private Node first, last;
	
	/**
	 * constructs the object.
	 */
	public QueueOfStrings() {
		first = null;
		last = null;
	}
	
	/**
	 * adds a String element in the queue at the end.
	 * @param s an element of String type
	 */
	public void enqueue(String s) {
		Node oldLast = last;
		last = new Node();
		last.item = s;
		last.next = null;
		if (isEmpty()) 
			first = last;
		else 
			oldLast.next = last;
	}
	
	/**
	 * removes the element from the queue.
	 * @return an element of type String.
	 * 
	 */
	public String dequeue() {
		String item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		return item;
	}
	
	/**
	 * checks to see if the queue is empty.
	 * @return true if queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	
	/**
	 * Node class represents a node used to store each element
	 * of the queue. It is the underlying implementation of the queue
	 * not accessible to client via API.
	 * 
	 * @author Ashish Chopra
	 *
	 */
	private class Node {
		String item;
		Node next;
	}
}