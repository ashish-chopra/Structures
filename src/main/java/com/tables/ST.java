/* 
 *  File: ST.java
 *  Author: Ashish Chopra
 *  Date: 3 June, 2015
 *  ---------------------------------------------------
 *  ST stands for Symbol table. This is an implementation
 *  of a symbol table for ordered data. When the keys are stored
 *  in an order. The search and insert operations can be performed
 *  in logarithmic time.
 *  
 *  Due to orderness in keys, various other operations like min, max, range,
 *  rank, select floor, ceiling etc are supported.
 *  
 */
package com.tables;

import com.queues.Queue;


public class ST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	private int capacity = 2;
	
	/**
	 * creates a new symbol table object
	 */
	@SuppressWarnings("unchecked")
	public ST() {
		this.keys = (Key[]) new Comparable[capacity];
		this.vals = (Value[]) new Object[capacity];
		this.N = 0;
		
	}

	/**
	 * returns the current size of ST.
	 * @return
	 */
	public int size() {
		return N;
	}
	
	/**
	 * checks to see if symbol table is empty.
	 * @return
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	
	
	/**
	 * inserts the given key-value pair in the symbol table
	 * if not present already. In case key is found, then 
	 * corresponding value is replaced.
	 * 
	 * if value is null, then key will be deleted from the table.
	 * @param key
	 * @param val
	 */
	@SuppressWarnings("unchecked")
	public void put(Key key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("key is null");
		
		int i = rank(key);
		if ( i < N && key.compareTo(keys[i]) == 0) {
			vals[i] = val;
			return;
		}
		
		if (size() == capacity) {
			keys = (Key[]) resizeKeys(keys, capacity * 2);
			vals = (Value[]) resize(vals, capacity * 2);
			capacity = capacity * 2;
		}
		
		for (int j = N; j > i; j--) {
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	/*
	 * resizes the array incase it is filled.
	 */
	private Object[] resize(Object[] arr, int size) {
		Object[] temp = new Object[size];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		return temp;
	}
	
	/*
	 * resizes the keys array incase it is filled.
	 */
	private Object[] resizeKeys(Comparable[] arr, int size) {
		Comparable[] temp = new Comparable[size];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		return temp;
	}
	
	
	/**
	 * retrieves the value corresponding to a given key
	 * in the symbol table.
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("search key is null");
		
		int i = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0) 
			return vals[i];
		else
			return null;
	}
	
	/**
	 * checks to see if the given key is 
	 * present in symbol table.
	 * @param key
	 * @return
	 */
	public boolean contains(Key key) {
		Value val = get(key);
		return val != null;
	}
	
	public void delete(Key key) {
		if (key == null) 
			throw new IllegalArgumentException("key is null");
		
		int i = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0) {
			for (int j = i; j < N; j++) {
				keys[j] = keys[j+1];
				vals[j] = vals[j+1];
			}
			N--;
		}
	}
	
	public Key min() {
		if (isEmpty()) return null;
		return keys[0];
	}
	
	public Key max() {
		if (isEmpty()) return null;
		return keys[N-1];
	}
	
	public Key floor(Key key) {
		if (key == null) 
			throw new IllegalArgumentException("key is null");
		int i = rank(key);
		return keys[--i];
	}
	
	public Key ceiling(Key key) {
		if (key == null) 
			throw new IllegalArgumentException("key is null");
		int i = rank(key);
		return keys[i];
	}
	
	public int rank(Key key) {
		if (isEmpty()) return 0;
		return rank(key, 0, N-1);
	}
	
	private int rank(Key key, int lo, int hi) {
		
		while (lo <= hi) {
			int mid = lo + (hi- lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			
			if (cmp == 0)
			   return mid;
			else if (cmp > 0) {
				lo = mid + 1;
			}
			else if (cmp < 0) {
				hi = mid - 1;
			}
		}
		return lo;
	}
	
	/**
	 * returns the key at the given rank in the table.
	 * @param rank an Integer
	 * @return Key
	 */
	public Key select(int rank) {
		if (rank >= N) return null;
		return keys[rank];
	}

	/**
	 * iterates the keys in the symbol table
	 * @return an iterator on the keys in the data structure
	 */
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (int i = 0; i < N; i++) {
			queue.enqueue(keys[i]);
		}
		return queue;
	}
}
