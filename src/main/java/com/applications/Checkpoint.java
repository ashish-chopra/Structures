/*
 *	File: Checkpoint.java
 *	Author: Ashish Chopra
 *	Date: 27 Nov, 2015
 * ----------------------------------------------------
 *  Checkpoint data structure is used to store actions of an application.
 *  It also provides functionality to undo an action or redo an action.
 *  
 *  This data structure only abstracts the said functionality, without getting
 *  into the details of performing actions. Hence for simplicity, i took
 *  the action to be an integer code that will be stored in the data structure.
 *  
 *  Checkpoint API
 *  ---------------------------------------------------------
 *  		Checkpoint()			// creates a new checkpoint data structure
 *  boolean add(Item actionCode)	// adds the action code
 *  Item	undo()					// undo the last performed action.
 *  Item	redo()					// redo the last performed undo action.
 *  int		size()					// return the size of all actions stored as of yet.
 *  boolean	isEmpty()				// returns is the checkpoint list is empty.
 *  
 *  
 *    
 */
package com.applications;

import com.stacks.Stack;

public class Checkpoint<Item> {

	private Stack<Item> current;	// maintains the list of actions performed in chronological order.
	private Stack<Item> removed;	// maintains the list of actions undone from current list in chronological order.
	
	public Checkpoint() {
		current = new Stack<Item>();
		removed = new Stack<Item>();
	}
	
	/**
	 * adds the currently performed action code in the checkpoint list.
	 * when an action is performed, the last undo action list is discarded.
	 * @param checkpoint
	 */
	public void add(Item checkpoint) {
		if (checkpoint == null)
			throw new IllegalArgumentException("checkpoint to add is null");
		
		if (!removed.isEmpty()) {
			//removed.clear()   // i have implemented this function yet in stack API
		}		
		current.push(checkpoint);
	}
	
	/**
	 * undo the last performed operation/checkpoint.
	 * @return operation code of last action.
	 */
	public Item undo() {
		if (current.isEmpty()) {
			return null;
		}
		Item item = current.pop();
		removed.push(item);
		return item;
	}
	
	
	/**
	 * redoes the last undone operation.
	 * @return the operation/item code
	 */
	public Item redo() {
		if (removed.isEmpty()) {
			return null;
		}
		
		Item item = removed.pop();
		current.push(item);
		return item;
	}
	
	/**
	 * gets the current size of checkpoint object.
	 * It is the sum of current operations and undo operations
	 * recorded.
	 * @return size as <code>int</code>
	 */
	public int size() {
		return current.size() + removed.size();
	}
	
	/**
	 * checks if the checkpoint object is empty.
	 * @return <code>true</code> if is empty,
	 * 		   <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		return current.isEmpty() && removed.isEmpty();
	}
}
