package com.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node first, last;
	public Deque() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null && last == null;
	}
	
	public int size() {
		return 0;
	}
	
	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException("null values cannot be inserted.");
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		if (last == null) last = first;
		
	}
	
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException("null values cannot be inserted.");
		
		if (isEmpty())
			addFirst(item);
		else {
			Node oldLast = last;
			last = new Node();
			last.item = item;
			last.next = null;
			oldLast.next = last;
		}
	}
	
	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("no element exists on deque.");
		
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public Item removeLast() {
		return null;
	}
	
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	
	private class Node {
		Item item;
		Node next;
	}
	
	private class DequeIterator implements Iterator<Item> {

		public boolean hasNext() {
			return false;
		}

		public Item next() {
			return null;
		}

		public void remove() {
			
		}
	}
	
}
