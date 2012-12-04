/*
 * File: Queue.java
 * Author: Ashish Chopra
 * Date: 29 Nov, 2012
 * -----------------------------------------
 * Queue is a generic data structure to store data items
 * of any type in queue fashion. Items are maintained in 
 * first-in-first-out manner in the queue.
 *  
 */
package com.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Queue is a generic data structure to store elements in 
 * first-in-first-out manner.
 *
 * @author Ashish Chopra
 * @version 1.0
 * @param <Item>
 * 
 */
public class Queue<Item> implements Iterable<Item> {

	private Node first, last;
	
	/**
	 * creates a new empty Queue object.
	 * 
	 */
	public Queue() {
	
		first = null;
		last = null;
	}
	
	/**
	 * inserts the given item into the queue.
	 * @param item Item to be stored.
	 */
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) 
			first = last;
		else     	   
			oldLast.next = last;
	}
	
	/**
	 * removes the least recent item from the queue.
	 * @return an item from the queue.
	 */
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	/**
	 * checks to see if queue is empty.
	 * @return true if queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * returns an iterator over the elements of the queue.
	 */
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class Node {
		Item item;
		Node next;
	}
	
	private class QueueIterator implements Iterator<Item> {

		Node current = first;
		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException("Operation is not supported");
		}
		
	}
}
