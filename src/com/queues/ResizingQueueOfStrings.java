package com.queues;

import java.util.NoSuchElementException;

public class ResizingQueueOfStrings {

	private String items[];
	private int head;
	private int tail;
	
	public ResizingQueueOfStrings() {
		items = new String[1];
		head = tail = 0;
	}
	
	public void enqueue(String item) {
		if (tail == items.length) resize(2 * items.length);
		items[tail++] = item;
	}
	
	public String dequeue() {
		if(isEmpty()) 
			throw new NoSuchElementException("No element is present in queue");
		String item = items[head];
		items[head++] = null;
		return item;
	}
	
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
