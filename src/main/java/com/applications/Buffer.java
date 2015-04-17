/*
 *  File: Buffer.java
 *  Author: Ashish Chopra
 *  Date Modified: 1 June, 2013
 *  --------------------------------------------------------
 *  Buffer is a representation of text editor buffers used in 
 *  actual text editors with simplified APIs as given below:
 *  
 *  Buffer
 *  -----------------------------------------------------------------
 *  	 Buffer()			creates an empty buffer
 *  void insert(char c)		insert a character c at cursor position.
 *  char delete()			deletes the character at cursor position.
 *  void left(int k)		moves the cursor k positions to the left.
 *  void right(int k)		moves the cursor k positions to the right.
 *  int  size()				number of characters in the buffer.
 *  
 *  This Buffer is an adopted version of "Gap Buffer" data structure used
 *  in famous text editors like Emacs and notepads.
 */
package com.applications;

import java.util.NoSuchElementException;
import com.stacks.Stack;

public class Buffer {

	private Stack<Character> first;  // primary stack to store characters
	private Stack<Character> second; // secondary stack used to support moving cursor.

	/**
	 * constructs a buffer object.
	 * 
	 */
	public Buffer() {
		first = new Stack<Character>();
		second = new Stack<Character>();
	}
	
	/**
	 * inserts the given character at the 
	 * cursor position in the buffer.
	 * @param c Character to be inserted.
	 */
	public void insert(char c) {
		first.push(c);
	}
	
	/**
	 * deletes the character from the cursor position.
	 * @throws NoSuchElementException if buffer is empty.
	 * @return character at cursor position.
	 */
	public char delete() {
		if (first.isEmpty())
			throw new NoSuchElementException();
		return first.pop();
	}
	
	/**
	 * moves the cursor to the left by given position.
	 * @param k the number of position to the left.
	 */
	public void left(int k) {
		int size = first.size();
		if (k > size) 
			throw new IllegalArgumentException("k is outside buffer size");
		while (k != 0) {
			second.push(first.pop());
			k--;
		}
	}
	
	/**
	 * moves the cursor to the right by given position.
	 * @param k the number of position to the right.
	 */
	public void right(int k) {
		int size = second.size();
		if (k > size)
			throw new IllegalArgumentException("k is outside buffer size");
		while (k != 0) {
			first.push(second.pop());
			k--;
		}
	}
	
	/**
	 * returns the size of buffer as number 
	 * of characters it occupies.
	 * @return number of characters in 
	 * buffer as <code>int</code>
	 */
	public int size() {
		return first.size() + second.size();
	}
	
	
	/*
	 * 
	 * A SIMPLE UNIT TEST CASE IMPLEMENTATION
	 * 
	 */
	public static void main(String[] args) {
	
	}

}
