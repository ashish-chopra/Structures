/*
 *  File: BSTTest.java
 *  Author: Ashish Chopra
 *  Date: 18 Nov, 2015
 *  -----------------------------------------------------
 *  
 *  This class tests the APIs of binary search tree implementation
 *  BST in com.trees package.
 *  
 */
package com.trees;

import junit.framework.TestCase;

public class BSTTest extends TestCase {
	
	public void testBSTInstantiation() {
		BST<Integer, String> bst = new BST<Integer, String>();
		assertEquals(true, bst.isEmpty());
		assertEquals(0, bst.size());
		assertEquals(null, bst.get(50));
	}
	
	public void testBSTOperations() {
		BST<Integer, String> bst = new BST<Integer, String>();
		bst.put(1, "Ashish1");
		bst.put(3, "Ashish3");
		bst.put(6, "Ashish6");
		bst.put(2, "Ashish2");
		bst.put(5, "Ashish5");
		bst.put(9, "Ashish9");
		bst.put(11, "Ashish11");
		bst.put(120, "Ashish120");
		
		assertEquals(8, bst.size());
		assertEquals(false, bst.isEmpty());
		assertEquals("Ashish5", bst.get(5));
		
		assertEquals(new Integer(120), bst.max());
		assertEquals(new Integer(1), bst.min());
		assertEquals(new Integer(3), bst.floor(4));
		assertEquals(new Integer(5), bst.floor(5));
		assertEquals(new Integer(6), bst.floor(7));
		
		assertEquals(new Integer(5), bst.ceiling(4));
		assertEquals(new Integer(5), bst.ceiling(5));
		assertEquals(new Integer(9), bst.ceiling(7));
		
		bst.put(new Integer(11), "AshishChanged11");
		bst.put(new Integer(20), "Ashish20");
		
		assertEquals("AshishChanged11", bst.get(11));
		assertEquals(9, bst.size());
		
	}
	
	public void testDeleteOperations() {
		BST<Integer, String> bst = new BST<Integer, String>();
		bst.put(1, "Ashish1");
		bst.put(3, "Ashish3");
		bst.put(6, "Ashish6");
		bst.put(2, "Ashish2");
		bst.put(5, "Ashish5");
		bst.put(9, "Ashish9");
		bst.put(11, "Ashish11");
		bst.put(120, "Ashish120");
		
		assertEquals("Ashish1", bst.get(1));
		assertEquals(8, bst.size());
		bst.deleteMin();
		assertEquals(null, bst.get(1));
		assertEquals(7, bst.size());
		bst.delete(120);
		assertEquals(null, bst.get(120));
		assertEquals(6, bst.size());
	}
	
	
}
