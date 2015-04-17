package com.stacks;

import junit.framework.TestCase;

public class FixedCapacityStackOfStringsTest extends TestCase {

	public void testStackOperations() {
		
		//testing empty stack
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
		assertEquals(true, stack.isEmpty());
		assertEquals(0, stack.size());
		
		// testing push
		stack.push("quick");
		stack.push("brown");
		stack.push("fox");
		assertEquals(false, stack.isEmpty());
		assertEquals(3, stack.size());
		
		// testing pop
		assertEquals("fox", stack.pop());
		assertEquals("brown", stack.pop());
		assertEquals(1, stack.size());
		assertEquals("quick", stack.pop());
		assertEquals(true, stack.isEmpty());
		assertEquals(0, stack.size());
		
		// testing underflow
		try {
			stack.pop();
		} catch (ArrayIndexOutOfBoundsException e) {
			assertNotNull(e);
		}
			
		
		
	}
	
}
