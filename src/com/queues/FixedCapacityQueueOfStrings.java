package com.queues;

import java.util.NoSuchElementException;

public class FixedCapacityQueueOfStrings {

	private String[] items;
	private int tail;
	private int head;
	
	public FixedCapacityQueueOfStrings(int capacity) {
		items = new String[capacity];
		tail = head = 0;
	}
	
	public void enqueue(String item) {
		items[tail++] = item;
	}
	
	public String dequeue() {
		if(isEmpty())
			throw new NoSuchElementException("No element in queue");
		String item = items[head];
		items[head++] = null;
		return item;
	}
	
	public boolean isEmpty() {
		return tail == head ;
	}
	
}
