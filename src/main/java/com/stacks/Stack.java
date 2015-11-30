/*
 * File: Stack.java
 * Date: 25 Sept, 2012
 * Author: Ashish Chopra
 * -----------------------------------------------
 * 
 *  *  Features:
 *  
 *  1. Stack is implemented as an abstract data type which separates
 *     the interface from the implementation of the class.
 *  2. It is a generic implementation which can store any type of data items,
 *     once defined.   
 *  3. Corner cases like Stack underflow and unsupported operations are taken care by
 *     throwing the NoSuchElementException, UnsupportedOperationException respectively. 
 *  4. The implementation is based on link based structure.
 *  5. The data structure is also iterable which abstracts the way we can traverse over
 *     the elements stored in it withour exposing the underlying implementation details. 
 *  6. The running time complexity of each operation is constant, O(1).
 *  7. The memory space occupied on program stack by nodes are 40N. The memory on heap is
 *     extra.
 *  
 */
package com.stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack is a general implementation of abstract data structure
 * to store any homogenous type of elements in Last-In-First-Out
 * fashion. 
 * 
 * @author Ashish Chopra
 * @param <Item> any type that extends Object.
 * @version  1.0
 */
public class Stack<Item> implements Iterable<Item> {

	private Node first;
	
	/**
	 * Constructs a Stack object.
	 *  
	 */
	public Stack() {
		first = null;
	}
	
	/**
	 * inserts an item into the stack.
	 * @param item An item to be added onto the stack.
	 */
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	/**
	 * removes the last item inserted in the stack.
	 * @return an item inserted recently.
	 */
	public Item pop() {
		if(isEmpty())
			throw new NoSuchElementException("No item present on stack");
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	/**
	 * retrieves the last item inserted in the stack, but does not remove
	 * @return an item inserted recently.
	 */
	public Item peek() {
		if(isEmpty())
			throw new NoSuchElementException("No item present on stack");
		Item item = first.item;
		return item;
	}
	
	/**
	 * checks to see if stack is empty.
	 * @return true if stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	
	/**
	 * returns the number of elements in the stack.
	 * @return the size of stack as integer.
	 */
	public int size() {
		int count = 0;
		for(Item item : this) {
			count++;
		}
		return count;
	}

	/**
	 * clears the stack object by permanently deleting the content.
	 * Once this action is performed, it cannot be undone.
	 */
	public void clear() {
		first = null;
	}
	/**
	 * returns an iterator over the stack data structure.
	 * 
	 */
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
		
	/**
	 * Node class represents a single node used to store single
	 * element on the stack in a link based implementation.
	 * 
	 * @author Ashish Chopra
	 *
	 */
	private class Node {
		Item item;
		Node next;
	}

	/**
	 * StackIterator implements Iterator interface
	 * to provide iterable capabilities to the stack
	 * data structure.
	 * 
	 * @author Ashish Chopra
	 *
	 */
	private class StackIterator implements Iterator<Item> {

		private Node current = first;
		
		public boolean hasNext() {	
			return current != null;	
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException("Remove operation not supported on stack");
		}	
	}
}
