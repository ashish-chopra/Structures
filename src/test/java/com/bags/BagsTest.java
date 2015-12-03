package com.bags;

import java.util.Iterator;
import junit.framework.TestCase;

public class BagsTest extends TestCase {
	
	public void testBagSize() {

		// testing the initial size of the bag.
		Bag<Integer> balls = new Bag<Integer>();
		assertEquals(true, balls.isEmpty());
		assertEquals(0, balls.size());	
	}
	
	public void testAddOperation() {
		Bag<Integer> balls = new Bag<Integer>();
		// testing add operation
		balls.add(4);
		balls.add(5);
		balls.add(6);
		
		assertEquals(false, balls.isEmpty());
		assertEquals(3, balls.size());
		
	}
	
	//Infinitely running test.
	public void RemoveOperation() {
		Bag<Integer> balls = new Bag<Integer>();
		// testing add operation
		balls.add(4);
		balls.add(5);
		balls.add(6);
		// testing remove operation
		Iterator<Integer> it = balls.iterator();
			while (it.hasNext()) {
				try {
					it.remove();
				} catch (UnsupportedOperationException e) {
					assertNotNull(e);
				} catch (Throwable ex) {
					assertTrue(false);
				}
			}
	}

}