/*
 *  File: Steque.java
 *  Author: Ashish Chopra
 *  Date: 27 Nov, 2012
 *  ---------------------------------------
 *  Steque is stack-ended queue data structure which supports
 *  stack operations: pop and push, along with queue enqueue 
 *  operation.
 *  
 *  Salient features:
 *  1. Operations like push, pop, enqueue are supported.
 *  2. NullPointerException is thrown when null element is inserted.
 *  3. UnsupportedOperationException is thrown when using remove() method.
 *  4. The data structure is iterable and is implemented for generic type.
 *  
 */
package com.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 
 * Steque is a stack-ended data structure which 
 * supports stack operations as well as queue's 
 * enqueue operation.
 * 
 * @author Ashish Chopra
 * @version 1.0
 *
 */
public class Steque<Item> implements Iterable<Item> {

	private Node first, last;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public Steque() {
		first = last = null;
	}
	
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (first == null)
			first = last;
		else
			oldLast.next = last;
	}
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		if (last == null) 
			last = first;
	}
	
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("No element exists in Steque");
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public boolean isEmpty() {
		return first == null || last == null;
	}
	
	public int size() {
		int count = 0;
		for(Item item : this) {
			count++;
		}
		return count;
	}
	
	public Iterator<Item> iterator() {
		return new StequeIterator(); 
	}
	
	public class StequeIterator implements Iterator<Item> {
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
			throw new UnsupportedOperationException("Operation not supported");
			
		}
	}
}
