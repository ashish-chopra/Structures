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
package com.list;

/**
 * LinkedList is a generic data structure to store elements in 
 * list manner.
 *
 * @author Tarun Jain
 * @version 1.0
 * @param <Item>
 * 
 */

public class LinkedList<Item> {

	private Node head;
	private int listCount;
	
	/**
	 * creates a new empty 
	 * LinkedList object.
	 */
	public LinkedList() {
		head = new Node();
		listCount = 0;
	}
	
	/**
	 * return the number of item in list
	 * @return the size of list as integer
	 */
	public int size(){
		return listCount;
	}
	
	/**
	 * check to see if list is Empty
	 * @return true if list is Empty, false otherwise
	 */
	public boolean isEmpty(){
		return size() == 0;
	}
	
	
	/**
	 * append specified item to the end of this list
	 * @param item specifies the item to be added
	 */
	public void add(Item item) {
		Node currentNode = head;
		Node newNode = new Node(item);
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(newNode);
		listCount++;
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
		for (int i = 1; i < index && currentNode.getNext() != null; i++) {
			currentNode = currentNode.getNext();
		}
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		listCount++;
	}

	/**
	 * returns the item at specified position in the list  
	 * @param index specifies the position from the list in integer
	 * @return item in the list
	 * @throws IndexOutOfBoundsException if the index is out of range 
	 */
	public Node get(int index) throws IndexOutOfBoundsException {
		if (index <= 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		Node temp = head.getNext();
		for (int i = 1; i < index; i++) {
			if (temp.getNext() == null)
				return null;
			temp = temp.getNext();

		}
		return temp;
	}
	/**
	 * 
	 * remove the item at specified position in the list  
	 * @param index specifies the position from the list in integer
	 * @return true removed item from the list
	 */
	public boolean remove(int index) {
		if (index <= 0 || index > size()) {
			return false;
		}
		Node current = head;
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return false;
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--;
		return true;
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

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}
	}

}
