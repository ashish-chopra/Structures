/*
 * File: ResizingQueueOfStrings.java
 * Date: 24 Sept, 2012
 * Last Modified: 2 Feb, 2013
 * Author: Ashish Chopra
 * ----------------------------------------------
 * 
 *    
 */
package com.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * RandomizedQueueOfStrings is a queue  to store string items
 * in queue(FIFO) fashion. It supports the enqueue operation to add an item to
 * the queue, but dequeue operation removes a random item from data structure
 * instead of the first item from the queue.
 * 
 * @author Ashish Chopra
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	private int N;
	private Item[] items;
	private Random randomGenerator;
	
	/**
	 * constructs the RandomizedQueue object.
	 */
	public RandomizedQueue() {
		items = (Item[]) new Object[1];
		randomGenerator = new Random();
		N = 0;
	}
	
	/**
	 * inserts an item into the queue.
	 * @param item Item to be inserted in the queue.
	 */
	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException("null elements cannot be added.");
	
		if (N == items.length) resize(N * 2);
		items[N++] = item;
	}
	
	/**
	 * checks to see if queue is empty.
	 * @return <code>true</code> if empty, <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	
	/**
	 * returns the size of the queue.
	 * @return size as Integer.
	 */
	public int size() {
		return N;
	}
	
	/**
	 * removes a randomly chosen item from the queue. If queue is empty,
	 * throws NoSuchElementException.
	 * @return a randomly chosen item from queue.
	 */
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty, by the way!!");
		
		int index = randomGenerator.nextInt(N);
		Item item = items[index];
		items[index] = items[N-1];
		items[N-1] = null;
		N--;
		return item;
	}
	
	/**
	 * returns a randomly chosen item from the queue without removing it.
	 * Throws NoSuchElementException when queue is empty.
	 * @return an item from the queue.
	 */
	public Item sample() {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty, by the way!!");
		
		int index = randomGenerator.nextInt(N);
		Item item = items[index];
		return item;
	}
	
	/**
	 * returns an iterator of this random queue object.
	 */
	public Iterator<Item> iterator() {
		return new RandomQueueIterator();
	}
	
	
	private void resize(int size) {
		Item[] list = (Item[]) new Object[size];
		for (int i = 0; i < N; i++) {
			list[i] = items[i];
		}
		items = list;
	}
	
	private class RandomQueueIterator implements Iterator<Item> {
		
		private int current = 0;

		public boolean hasNext() {
			return current != N;
		}
	
		public Item next() {
			Item item = items[current++];
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException("Remove not supported :(");
		}		
	}
}
