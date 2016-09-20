/*
 * File: LinkedList.java
 * Author: Tarun Jain
 * Date: 1 Feb, 2016
 * -----------------------------------------
 * LinkedList is a generic data structure to store data items
 * of any type in list fashion.  
 * 
 *  
 */
package com.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList is a generic data structure to store elements in 
 * list manner.
 * 
 * LinkedList provides following API
 * ----------------------------------------------
 *         LinkedList ()                   // constructs a empty list.
 * int     size()                      // returns the length of list in integer.
 * boolean isEmpty()               // returns true if list is empty, false otherwise.
 * void    add(Item item)      	   // append an item in the last of list.
 * void    add(Item item, int index)  //append an item at the given index in the list.
 * Item    get(int index)             // returns the item at the given index from the list.
 * boolean remove(int index)	   // remove the node and return true at the given index from the list.
 * Iterator<Item> iterator()   	   // Iterate over the linkedList
 *
 * @author Tarun Jain
 * @version 1.0
 * @param <Item>
 * 
 */

public class LinkedList<Item> implements Iterable<Item>{

	private Node head;
	private int N;
	
	/**
	 * creates a new empty 
	 * <code>LinkedList</code> object.
	 */
	public LinkedList() {
		head = null;	
		N = 0;
	}
	
	/**
	 * return the number of item in list
	 * @return the size of list as integer
	 */
	public int size(){
		return N;
	}
	
	/**
	 * checks to see if list is empty.
	 * @return <code>true<code> if list is empty, <code>false</code> otherwise.
	 */
	public boolean isEmpty(){
		return N == 0;
	}
	
	
	/**
	 * append specified item to the end of this list
	 * @param item specifies the item to be added
	 */   
	public void add(Item item) {
		Node currentNode = head;  
		Node newNode = new Node(item);// reference of head is passed in temporary Node variable
		if(isEmpty()){
			head = newNode;
			N++;
			return;
		}
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		N++;
	}

	/**
	 * append the specified item to the specified index of the list
	 * @param item specifies the item to be added
	 * @param index specifies the index value at which specified item to be added in integer
	 * @throws IndexOutOfBoundsException if the index is out of range 
	 */
	public void add(Item item, int index) throws IndexOutOfBoundsException{
		if (index <= 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		Node currentNode = head;
		Node newNode = new Node(item);
		if(isEmpty()){
			head = newNode;
			N++;
			return;
		}
		int position = index-1;
		for (int i = 1; i < position && currentNode.next != null; i++) {
			currentNode = currentNode.next;
		}
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		N++;
	}

	/**
	 * returns the item at specified position in the list  
	 * @param index specifies the position from the list in integer
	 * @return item in the list
	 * @throws IndexOutOfBoundsException if the index is out of range 
	 */
	public Item get(int index) throws IndexOutOfBoundsException {
		if (index <= 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		Node temp = head;
		for (int i = 1; i < index; i++) {
			if (temp.next == null)
				return null;
			temp = temp.next;

		}
		return temp.item;
	}
	/**
	 * 
	 * remove the node at specified position in the list  
	 * @param index specifies the position from the list in integer
	 * @return true removed node from the list
	 */
	public boolean remove(int index) {
		if (index <= 0 || index > size()) {
			return false;
		}
		Node current = head;
		for (int i = 1; i < index; i++) {
			if (current.next == null)
				return false;
			current = current.next;
		}
		current.next = current.next.next;
		N--;
		return true;
	}
	
	
	/**
	 * returns an iterator over the LinkedList.
	 * 
	 */
	public Iterator<Item> iterator()  { return new LinkedListIterator(); }
	
	
	/*
	 * LinkedListIterator implements Iterator interface
	 * to provide Iterable capabilities to the LinkedList
	 * data structure.
	 * 
	 *
	 */
	private class LinkedListIterator implements Iterator<Item> {
        private Node current = head;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

	private class Node {
		Node next;
		Item item;

		public Node(Item item) {
			this.item = item;
			this.next = null;
		}
		
		public Node() {
			this.item = null;
			this.next = null;
		}

		public Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}

		
	}

}
