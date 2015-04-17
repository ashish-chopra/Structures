package com.stacks;

import junit.framework.TestCase;

public class StackOfStringsTest extends TestCase {

	public void testStackOfStrings() {
	
		// creating empty test
		StackOfStrings stack = new StackOfStrings();
		assertEquals(true, stack.isEmpty());
		
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
		} catch (NullPointerException e) {
			assertNotNull(e);
		} catch (Exception e) {
			assertNull(e);
		}
	   	
		
		
	}
}
