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


public class ST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	/**
	 * creates a new symbol table object
	 * @param capacity size of the symbol table as int.
	 */
	public ST(int capacity) {
		keys = (Key[]) new Object[capacity];
		vals = (Value[]) new Object[capacity];
		N = 0;
		
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
	
	
	public void put(Key key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("key is null");
		
		int i = rank(key);
		if ( i < N && key.compareTo(keys[i]) == 0) {
			vals[i] = val;
			return;
		} else {
			// to do.
		}
		
	}
	
	/**
	 * retreives the value corresponding to a given key
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
		
	}
	
	public Key min() {
		if (isEmpty()) 
			return null;
		return keys[0];
	}
	
	public Key max() {
		if (isEmpty())
			return null;
		return keys[N];
	}
	
	public Key floor(Key key) {
		return null;
	}
	
	public Key ceiling(Key key) {
		return null;
	}
	
	public int rank(Key key) {
		return 0;
	}
	
	public Key select(int rank) {
		return null;
	}

	public Iterable<Key> keys() {
		return null;
	}
}
