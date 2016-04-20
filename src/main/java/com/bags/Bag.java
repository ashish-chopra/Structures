/*
 *  File: Bag.java
 *  Date: 25 Jan, 2013
 *  Date Modified: 6 Feb, 2013 
 *  Author: Ashish Chopra
 *  --------------------------------------------------
 *  A bag is a simple collection data structure that represents a
 *  collection of items irrespective of how it stores them and allow user
 *  to retrieve those items and iterate over them without removing it.
 *  
 *  
 */
package com.bags;

import java.util.Iterator;

/**
 * 
 * Bag data structure is used to store collection of items 
 * irrespective of fashion they inserted. It allows user to add an item 
 * and iterate over the collection of items, determine the size etc.
 * But it does not support removal of item from Bag.
 * 
 * @author Ashish Chopra
 * @version 1.0
 *
 */
public class Bag<T> implements Iterable<T> {

	
	private T[] contents;  
	private int N;
	
	/**
	 * creates a new empty Bag.
	 */
	public Bag() {
		contents = (T[]) new Object[1];
		N = 0;
	}
	
	/**
	 * 
	 * checks to see if Bag is empty.
	 * @return <code>true</code> if empty, <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	
	
	/**
	 * adds an item into the bag.
	 * @param item An item need to be added.
	 */
	public void add(T item) {
		if (item == null)
			throw new NullPointerException("You cannot fool us with null insertion :)");
		if (N == contents.length) 
			resize(contents.length * 2);
		contents[N++] = item;
	}

	
	/**
	 * returns an iterator over the elements of the bag.
	 * 
	 */
	public Iterator<T> iterator() {
		return new BagIterator();
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int size) {
		T[] items = (T[]) new Object[size];
		for (int i = 0; i < N; i++) {
			items[i] = contents[i];
		}
		contents = items;
	}
	
	
	private class BagIterator implements Iterator<T> {

		private int current;
		
		public BagIterator() {
			current = 0;
		}
		
		public boolean hasNext() {
			return current != N;
		}

		public T next() {
			return contents[current++]; 
		}

		public void remove() {
			throw new UnsupportedOperationException("Boo! Operation not supported :(");
		}
		
	}

	
}
