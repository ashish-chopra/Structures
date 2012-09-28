package com.queues;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private int size;
	private Node first, last;
	
	public RandomizedQueue() {
		size = 0;
		first = null;
		last = null;
	}
	
	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException("null elements cannot be added.");
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		size++;
		if (isEmpty())
			first = last;
		else {
			last.prev = oldLast;
			oldLast.next = last;
		}
	}
	
	public Item dequeue() {
		return null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
	}
	
	public Item sample() {
		return null;
	}
	
	public Iterator<Item> iterator() {
		return null;
	}

	private class Node {
		Item item;
		Node next;
		Node prev;
	}

}
