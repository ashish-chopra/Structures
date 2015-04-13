/*
 *  File: MoveToFront.java
 *  Author: Ashish Chopra
 *  Date: 16 July, 2013
 *  -------------------------------------------------------
 *  MoveToFront is strategy used in many real world applications
 *  like caching, data compression and other applications where items
 *  that have been recently accessed are most likely to be reaccessed.
 *  
 *  In order to develop this, use linked list to store the 
 *  sequence of characters read from console and store every unseen character
 *  at the front of the list, and if any duplicate character is seen, deletes it
 *  from the list and re-insert it at the front.
 *  
 *  For brevity purpose only insertion operation is implemented in this program,
 *  read/delete operations can be implemented as iterator.
 *  
 */
package com.applications;

public class MoveToFront {

	private Node first;
	private int size;
	
	public MoveToFront() {
		first = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
	}
	
	public void push(char c) {
		Node node = lookup(c);
		if (node == null) {
			node = new Node();
			node.item = c;
			node.next = null;
		}
		push(node);
	}
	
	private void push(Node node) {
		if (!isEmpty())
			node.next = first;
		first = node;
	}
	
	private Node lookup(char c) {
		if (isEmpty())
			return null;
		Node node = first;
		Node prev = first;
		while (node != null) {
			if (node.item == c){
				if (node == first) 
					first = first.next;
				else {
					prev.next = node.next;
					node.next = null;
				}
				break;
			}
			prev = node;
			node = node.next;
		}
		return node;
	}
	
	private class Node {
		char item;
		Node next;
	}
}
