/*
 *  File: Subset.java
 *  Date: 17 Feb, 2013
 *  Author: Ashish Chopra
 *  ---------------------------------------------
 *  Deque is an abstract data structure and an adaptation
 *  of queue, such that the elements can be inserted and removed from
 *  the front as well as from the last.
 *  It is implemented for generic types of data using doublly linked list
 *  implementation.
 *  It also implements iterable interface to provide an iterator over the 
 *  elements from front to end.
 *  
 */
package com.applications;

import java.util.Iterator;
import com.queues.RandomizedQueue;

/**
 * This class tests the RandomizedQueue implementation by 
 * accepting N number of input strings and printing back 
 * random k strings back to the output.
 * @author Ashish Chopra
 *
 */
public class Subset {
	public static void main(String[] args) {
		
		int k = Integer.parseInt(args[0]);
		RandomizedQueue<String> list = new RandomizedQueue<String>();
		// while (!StdIn.isEmpty()) {
		// 	String input = StdIn.readString();
		// 	list.enqueue(input);
		// }
		
		Iterator<String> it = list.iterator();
		while (k > 0) {
			System.out.println(it.next());
			k--;
		}

	}

}
