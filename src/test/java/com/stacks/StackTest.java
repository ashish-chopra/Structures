package com.stacks;

import junit.framework.TestCase;

public class StackTest extends TestCase {

	public void testStack() {
	
		Stack<String> stack = new Stack<String>();
		stack.push("quick");
		stack.push("brown");
		stack.push("fox");
		stack.push("jumped");
		stack.push("over");
		stack.push("little");
		stack.push("lazy");
		stack.push("dog");
		
		assertEquals("dog",stack.peek());		
		assertEquals(8,  stack.size());		
		stack.pop();
		assertEquals("lazy",stack.peek());
	}
	
		
}
