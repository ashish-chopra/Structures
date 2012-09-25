package com.stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 *  Features:
 *  
 *  1. It is a generic Stack used for any type of data.
 *  2. It throws valid exceptions on stack underflow and unsupported
 *     operations.
 *  3. It is based on Link list implementation.
 *  4. It implements Iterable interface which provides traversing
 *     capabilities to the stack without exposing the detail of its
 *     implementation.
 * 
 */
public class Stack<Item> implements Iterable<Item> {

	private Node first;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public Stack() {
		first = null;
	}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public Item pop() {
		if(isEmpty())
			throw new NoSuchElementException("No item present on stack");
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public int size() {
		int count = 0;
		for(Item item : this) {
			count++;
		}
		return count;
	}

	public Iterator<Item> iterator() {
		return new StackIterator();
	}
		
	
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
