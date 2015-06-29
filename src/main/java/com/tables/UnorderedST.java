/*
 *  File: UnorderedST.java
 *  Author: Ashish Chopra
 *  Date: 3 June, 2015
 *  --------------------------------------------
 *  This is a data structure that represents a symbol table
 *  which stores unordered data. It is used to perform search
 *  and insert operations in unordered list.
 *  
 *  For an unordered list of data, the only way to search is to 
 *  perform linear search, hence the time complexity of this 
 *  structure is linear.
 *
 *	The underlying implementation of this symbol table uses Linked
 *  list because for an unordered list the operations are performed
 *  linearly, hence Linked List data structure is best suitable for it.
 *  
 *  This data structure is generally good for limited data, but as 
 *  your data grows, it becomes a overkill. Then we move towards 
 *  optimized STs.
 *  
 */
package com.tables;

/**
 * UnorderedST is a data structure to store searchable data in unordered
 * form. Each data item is associated with a key and value. The key is 
 * searchable. The search and insert operations are performed in linear time.
 * 
 * @author Ashish Chopra
 *
 */
public class UnorderedST<Key, Value> {

	private Node first;
	private int N;
	
	/**
	 * creates an empty unordered symbol
	 * table data structure object.
	 * 
	 */
	public UnorderedST() {
		first = null;
		N = 0;
	}
	
	
	/**
	 * Inserts a new data item in the symbol table, corresponding to the
	 * given <code>Key</code>. If <code>key</code> is already present, then
	 * its <code>value</code> is updated with new input.
	 * <br/>
	 * if Value is <code>null</code> then the key is removed from the 
	 * symbol table.
	 * 
	 * @param key  <code>Key</code> of the data item.
	 * @param val  <code>Value</code> of the data item.
	 */
	public void put(Key key, Value val) {
		if (key == null) 
			throw new IllegalArgumentException("search key is null");
		
		if (val == null) {
			delete(key);
			return;
		}
		
		// search the item in table
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		
		// grows the table, when item not found
		Node node = new Node(key, val, first);
		first = node;
		N++;
			
	}
	
	
	/**
	 * searches the given <code>key</code> in the
	 * symbol table to retrieve the corresponding 
	 * <code>value</code>.
	 * @param key
	 * @return <code>value</code> if key is found,
	 *         <code>null</code> otherwise.
	 */
	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("search key is null");
		
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				return x.val;
			}
		}
		return null;
	}
	
	/**
	 * checks if the given key is present in the
	 * symbol table.
	 * @param key  key to be searched.
	 * @return <code>true</code> if found, 
	 * 		   <code>false</code> otherwise.
	 */
	public boolean contains(Key key) {
		Value val = get(key);
		return val != null;
	}
	
	/**
	 * checks if the symbol table is empty.
	 * @return
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * returns the current size of symbol table.
	 * @return
	 */
	public int size() {
		return N;
	}
	
	/**
	 * deletes the item with a given key
	 * if found in the table.
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (key == null)
			throw new IllegalArgumentException("key to delete is null");
		
		Node current = first;
		Node prev = first;
		while (current != null) {
			if (key.equals(current.key)) {
				prev.next = current.next;
				return;
			}
			prev = current;
			current = current.next;
		}
	}
	
	/*
	 * Node implementation to store the data items
	 * for the symbol table.
	 */
	private class Node {
		Key key;
		Value val;
		Node next;
		
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
}
