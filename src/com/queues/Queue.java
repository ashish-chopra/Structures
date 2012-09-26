package com.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {

	private Node first, last;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public Queue() {
	
		first = null;
		last = null;
	}
	
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
	
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		Item item = first.item;
		first = first.next;
		return item;
		
		
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public Iterator<Item> iterator() {
		return null;
	}
	
	private class QueueIterator implements Iterator<Item> {

		public boolean hasNext() {
			return false;
		}

		public Item next() {
			return null;
		}

		public void remove() {
			throw new UnsupportedOperationException("Operation is not supported");
		}
		
	}
}
